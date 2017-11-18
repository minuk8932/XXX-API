package com.datasaver.api.services;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.datasaver.api.domains.Device;
import com.datasaver.api.domains.PushMessage;
import com.datasaver.api.domains.PushMessage.Status;
import com.datasaver.api.domains.PushMessage.Type;
import com.datasaver.api.domains.User;
import com.datasaver.api.domains.WiFi;
import com.datasaver.api.payloads.AddNoticePayload;
import com.datasaver.api.payloads.UpdateNoticePayload;
import com.datasaver.api.payloads.WiFiRequestPayload;
import com.datasaver.api.payloads.WiFiRequestResultPayload;
import com.datasaver.api.repositories.PushMessageRepository;
import com.datasaver.api.services.interfaces.PushMessageServiceInterface;
import com.datasaver.api.utils.gcm.GCM;
import com.datasaver.api.utils.gcm.GCMConfig;
import com.google.gson.Gson;

@Service("PushMessageService")
public class PushMessageService implements PushMessageServiceInterface {
	private static final int PAGE_SIZE = 20;

	@Autowired
	private PushMessageRepository pmr;

	@Autowired
	private UserService us;

	@Autowired
	private GCMConfig fc;

	@Autowired
	private DeviceService ds;

	@Autowired
	private EntityManager em;

	@Override
	public void sendAddNoticeMsg(AddNoticePayload addNoticePayload) {
		for (User u : us.findAll()) {
			PushMessage pm = new PushMessage();
			pm.setType(Type.ADD_NOTICE);
			pm.setPayload(new Gson().toJson(addNoticePayload));
			pm.setUser(u);
			pm.setIsRead(false);

			GCM gcm = new GCM(fc.getApiKey());
			Device d = ds.findByUser(u);

			if (d == null) {
				pm.setStatus(Status.FAIL);
			}

			else {
				JSONObject resJO = gcm.send("[DataSaver] 새로운 공지사항이 있어요.", addNoticePayload.getTitle(),
						getUnreadCounts(u) + 1, addNoticePayload, d.getToken());

				if (resJO != null) {
					pm.setLog(resJO.toString());
				}

				pm.setStatus(Status.SUCCESS);
			}

			pmr.save(pm);
		}
	}

	@Override
	public void sendUpdateNoticeMsg(UpdateNoticePayload updateNoticePayload) {
		for (User u : us.findAll()) {
			PushMessage pm = new PushMessage();
			pm.setType(Type.UPDATE_NOTICE);
			pm.setPayload(new Gson().toJson(updateNoticePayload));
			pm.setUser(u);
			pm.setIsRead(false);

			GCM gcm = new GCM(fc.getApiKey());
			Device d = ds.findByUser(u);

			if (d == null) {
				pm.setStatus(Status.FAIL);
			}

			else {
				JSONObject resJO = gcm.send("[DataSaver] 공지사항이 변경되었어요.", updateNoticePayload.getTitle(),
						getUnreadCounts(u) + 1, updateNoticePayload, d.getToken());

				if (resJO != null) {
					pm.setLog(resJO.toString());
				}

				pm.setStatus(Status.SUCCESS);
			}

			pm.setStatus(Status.SUCCESS);

			pmr.save(pm);
		}
	}

	@Override
	public boolean sendWiFiRequestMsg(User owner, User requester, WiFi wifi, WiFiRequestPayload wifiRequestPayload) {
		PushMessage pm = new PushMessage();
		pm.setType(Type.WIFI_REQUEST);
		pm.setPayload(new Gson().toJson(wifiRequestPayload));
		pm.setUser(owner);
		pm.setIsRead(false);

		GCM gcm = new GCM(fc.getApiKey());
		Device d = ds.findByUser(owner);

		if (d == null) {
			pm.setStatus(Status.FAIL);
		}

		else {
			JSONObject resJO = gcm.send("[DataSaver] WiFi 정보 공유 요청이 있어요.",
					requester.getName() + "님이 " + wifi.getSsid() + " 정보 공유를 요청했어요.", getUnreadCounts(owner) + 1,
					wifiRequestPayload, d.getToken());

			if (resJO != null) {
				pm.setLog(resJO.toString());
			}

			pm.setStatus(Status.SUCCESS);
		}

		pm.setStatus(Status.SUCCESS);

		pmr.save(pm);

		return true;
	}

	@Override
	public boolean sendWiFiRequestResultMsg(User requester, WiFi wifi,
			WiFiRequestResultPayload wifiRequestResultPayload) {
		PushMessage pm = new PushMessage();
		pm.setType(Type.WIFI_REQUEST_RESULT);
		pm.setPayload(new Gson().toJson(wifiRequestResultPayload));
		pm.setUser(requester);
		pm.setIsRead(false);

		GCM gcm = new GCM(fc.getApiKey());
		Device d = ds.findByUser(requester);

		if (d == null) {
			pm.setStatus(Status.FAIL);
		}

		if (wifiRequestResultPayload.getStatus()) {
			JSONObject resJO = gcm.send("[DataSaver] WiFi 정보 공유를 허락 받았어요.", wifi.getSsid() + " 정보를 추가했어요.",
					getUnreadCounts(requester) + 1, wifiRequestResultPayload, d.getToken());

			if (resJO != null) {
				pm.setLog(resJO.toString());
			}

			pm.setStatus(Status.SUCCESS);
		}

		else {
			JSONObject resJO = gcm.send("[DataSaver] WiFi 정보 공유를 거절당했어요.", wifi.getSsid() + " 정보 공유를 거절당했어요.",
					getUnreadCounts(requester) + 1, wifiRequestResultPayload, d.getToken());

			if (resJO != null) {
				pm.setLog(resJO.toString());
			}
		}

		pm.setStatus(Status.SUCCESS);

		pmr.save(pm);

		return true;
	}

	@Override
	public void save(PushMessage pushMessage) {
		pmr.save(pushMessage);
	}

	@Override
	public PushMessage findByIdx(long idx) {
		return pmr.findOne(idx);
	}

	@Override
	public Collection<PushMessage> findListByUser(User user, int page) {
		return pmr.findListByUser(user, new PageRequest(page, PAGE_SIZE, new Sort(Direction.DESC, "ts"))).getContent();
	}

	@Override
	public int getUnreadCounts(User user) {
		Query q = em.createNativeQuery("SELECT * FROM PushMessage WHERE uidx = ? AND isRead = 0", PushMessage.class);
		q.setParameter(1, user.getIdx());

		return q.getResultList().size();
	}
}
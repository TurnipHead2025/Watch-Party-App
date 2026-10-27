package com.watchparty.session;

import java.util.List;

import org.springframework.stereotype.Service;

import com.watchparty.production.Production;

@Service
public class WatchPartySessionService {
	private final WatchPartySessionRepository sessionRepository;

	public WatchPartySessionService(WatchPartySessionRepository sessionRepository) {
		this.sessionRepository = sessionRepository;
	}

	// methods
	
	public List<WatchPartySession> getAllSessions() {
		return sessionRepository.findAll();
	}

	public WatchPartySession getSessionById(Long id) {
		return sessionRepository.findById(id).orElse(null);
	}

	public WatchPartySession saveSession(WatchPartySession session) {
		return sessionRepository.save(session);
	}

	public void deleteSession(Long id) {
		sessionRepository.deleteById(id);
	}

	public WatchPartySession updateSession(Long id, WatchPartySession updatedSession) {
		WatchPartySession existingSession = sessionRepository.findById(id).orElse(null);

		if (existingSession != null) {
			Production production = updatedSession.getProduction();
			existingSession.setProduction(production);
			existingSession.setCurrentSceneIndex(updatedSession.getCurrentSceneIndex());
			existingSession.setCurrentBeatIndex(updatedSession.getCurrentBeatIndex());

			if (updatedSession.isPlaying()) {
				existingSession.play();
			} else {
				existingSession.pause();
			}

			return sessionRepository.save(existingSession);
		}

		return null;
	}
}

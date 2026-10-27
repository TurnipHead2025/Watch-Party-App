package com.watchparty.session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchPartySessionRepository extends JpaRepository<WatchPartySession, Long> {
}

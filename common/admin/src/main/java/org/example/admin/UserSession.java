package org.example.admin;

import org.example.utilities.StringUtils;
import org.example.list.LinkedList;
import java.time.LocalDateTime;

/**
 * Represents an active user session in the admin system.
 */
public class UserSession {
    private final String userId;
    private final LocalDateTime startTime;
    private final LinkedList activities;
    private LocalDateTime lastActivityTime;

    public UserSession(String userId) {
        this.userId = userId;
        this.startTime = LocalDateTime.now();
        this.lastActivityTime = startTime;
        this.activities = new LinkedList();
    }

    /**
     * Records a new activity in the session.
     *
     * @param activity description of the activity
     */
    public void recordActivity(String activity) {
        String timestamp = LocalDateTime.now().toString();
        activities.add(String.format("%s: %s", timestamp, activity));
        this.lastActivityTime = LocalDateTime.now();
    }

    /**
     * Gets the session duration in minutes.
     *
     * @return session duration in minutes
     */
    public long getSessionDurationMinutes() {
        return java.time.Duration.between(startTime, LocalDateTime.now()).toMinutes();
    }

    /**
     * Gets all activities as a formatted string.
     *
     * @return formatted activity log
     */
    public String getActivityLog() {
        return StringUtils.join(activities);
    }

    /**
     * Gets the time elapsed since the last activity.
     *
     * @return minutes since last activity
     */
    public long getMinutesSinceLastActivity() {
        return java.time.Duration.between(lastActivityTime, LocalDateTime.now()).toMinutes();
    }
}
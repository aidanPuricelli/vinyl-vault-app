package com.example.vinylvaultback.manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class SessionManager {
    /*

    // HttpServletRequest is injected automatically by Spring
    private final HttpServletRequest httpServletRequest;

    @Autowired
    public SessionManager(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public void setSessionUserId(Long userId) {
        HttpSession session = httpServletRequest.getSession(true); // Create a new session if it doesn't exist
        session.setAttribute("userId", userId); // Store the user's ID in the session
    }

    public Long getSessionUserId() {
        HttpSession session = httpServletRequest.getSession(false); // Do not create a new session if it doesn't exist
        if (session != null) {
            Object userIdAttribute = session.getAttribute("userId"); // "userId" is the session attribute name
            if (userIdAttribute instanceof Long) {
                return (Long) userIdAttribute;
            }
        }
        return null; // If no user ID is found in the session or the session doesn't exist
    }
    */
}

/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.picketbox.core.config;

/**
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 *
 */
public class PicketBoxConfiguration {

    private AuthenticationConfiguration authentication;
    private AuthorizationConfiguration authorization;
    private GlobalIdentityManagerConfiguration identityManager;
    private SessionManagerConfig sessionManager;
    private EventManagerConfiguration eventManager;

    public PicketBoxConfiguration(AuthenticationConfiguration authentication, AuthorizationConfiguration authorization,
            GlobalIdentityManagerConfiguration identityManager, SessionManagerConfig sessionManager, EventManagerConfiguration eventManager) {
        this.authentication = authentication;
        this.authorization = authorization;
        this.identityManager = identityManager;
        this.sessionManager = sessionManager;
        this.eventManager = eventManager;
    }

    /**
     * @return the authentication
     */
    public AuthenticationConfiguration getAuthentication() {
        return authentication;
    }

    /**
     * @return the authorization
     */
    public AuthorizationConfiguration getAuthorization() {
        return authorization;
    }

    /**
     * @return the identityManager
     */
    public GlobalIdentityManagerConfiguration getIdentityManager() {
        return identityManager;
    }

    public SessionManagerConfig getSessionManager() {
        return this.sessionManager;
    }

    public EventManagerConfiguration getEventManager() {
        return this.eventManager;
    }
}

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
package org.picketbox.core.authentication.impl;

import java.util.ArrayList;
import java.util.List;

import org.picketbox.core.PicketBoxManager;
import org.picketbox.core.authentication.AuthenticationMechanism;
import org.picketbox.core.authentication.AuthenticationProvider;
import org.picketbox.core.config.PicketBoxConfiguration;

/**
 * <p>
 * Base class for {@link AuthenticationProvider} implementations.
 * </p>
 *
 * @author <a href="mailto:psilva@redhat.com">Pedro Silva</a>
 *
 */
public abstract class AbstractAuthenticationProvider implements AuthenticationProvider {

    private final List<AuthenticationMechanism> mechanisms = new ArrayList<AuthenticationMechanism>();
    private PicketBoxManager picketBoxManager;

    public AbstractAuthenticationProvider(PicketBoxManager picketBoxManager, PicketBoxConfiguration configuration) {
        this.picketBoxManager = picketBoxManager;
        this.mechanisms.addAll(configuration.getAuthentication().getMechanisms());
    }

    /*
     * (non-Javadoc)
     *
     * @see org.picketbox.core.authentication.spi.AuthenticationProvider#getSupportedMechanisms()
     */
    public String[] getSupportedMechanisms() {
        String[] mechanisms = new String[this.mechanisms.size()];

        int i = 0;

        for (AuthenticationMechanism entry : this.mechanisms) {
            mechanisms[i++] = entry.getClass().getName();
        }

        return mechanisms;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.picketbox.core.authentication.spi.AuthenticationProvider#supports(java.lang.String)
     */
    public boolean supports(String mechanismName) {
        for (AuthenticationMechanism mechanism : this.mechanisms) {
            if (mechanism.getClass().getName().equals(mechanismName)) {
                return true;
            }
        }
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.picketbox.core.authentication.spi.AuthenticationProvider#getMechanism(java.lang.String)
     */
    public AuthenticationMechanism getMechanism(String mechanismName) {
        for (AuthenticationMechanism currentMechanism : this.mechanisms) {

            if (currentMechanism instanceof AbstractAuthenticationMechanism) {
                ((AbstractAuthenticationMechanism) currentMechanism).setPicketBoxManager(this.picketBoxManager);
            }

            if (currentMechanism.getClass().getName().equals(mechanismName)) {
                return currentMechanism;
            }
        }

        return null;
    }

}
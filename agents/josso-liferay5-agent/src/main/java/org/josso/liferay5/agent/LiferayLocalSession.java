/*
 * JOSSO: Java Open Single Sign-On
 *
 * Copyright 2004-2009, Atricore, Inc.
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
 *
 */

package org.josso.liferay5.agent;

import org.josso.agent.http.JOSSOSecurityContext;
import org.josso.agent.http.WebAccessControlUtil;

import javax.servlet.http.HttpSession;

/**
 * This LocalSession implementation provides a placeholder for the JOSSO Security Context used by this agent.
 *
 * @author <a href="mailto:dfisic@josso.org">Dusan Fisic</a>
 */
public class LiferayLocalSession extends LocalSessionImpl {

    public LiferayLocalSession(HttpSession httpSession) {
        super();

        setWrapped(httpSession);
        setMaxInactiveInterval(httpSession.getMaxInactiveInterval());

    }

    public void setSecurityContext(JOSSOSecurityContext ctx) {
        HttpSession session = (HttpSession) getWrapped();
        session.setAttribute(WebAccessControlUtil.KEY_JOSSO_SECURITY_CONTEXT, ctx);
    }
}

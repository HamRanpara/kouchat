
/***************************************************************************
 *   Copyright 2006-2013 by Christian Ihle                                 *
 *   kontakt@usikkert.net                                                  *
 *                                                                         *
 *   This file is part of KouChat.                                         *
 *                                                                         *
 *   KouChat is free software; you can redistribute it and/or modify       *
 *   it under the terms of the GNU Lesser General Public License as        *
 *   published by the Free Software Foundation, either version 3 of        *
 *   the License, or (at your option) any later version.                   *
 *                                                                         *
 *   KouChat is distributed in the hope that it will be useful,            *
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU      *
 *   Lesser General Public License for more details.                       *
 *                                                                         *
 *   You should have received a copy of the GNU Lesser General Public      *
 *   License along with KouChat.                                           *
 *   If not, see <http://www.gnu.org/licenses/>.                           *
 ***************************************************************************/

package net.usikkert.kouchat.util;

import java.lang.management.ManagementFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import net.usikkert.kouchat.Constants;
import net.usikkert.kouchat.misc.Controller;
import net.usikkert.kouchat.misc.ControllerInformation;
import net.usikkert.kouchat.misc.ControllerInformationMBean;
import net.usikkert.kouchat.misc.GeneralInformation;
import net.usikkert.kouchat.misc.GeneralInformationMBean;
import net.usikkert.kouchat.net.ConnectionWorker;
import net.usikkert.kouchat.net.NetworkInformation;
import net.usikkert.kouchat.net.NetworkInformationMBean;

/**
 * Registers JMX MBeans.
 *
 * <p>Connect to <code>KouChat</code> with <code>JConsole</code> to get access
 * to the MBeans. <code>JConsole</code> is part of the Java SDK.</p>
 *
 * <p>The following MBeans are registered:</p>
 *
 * <ul>
 *   <li>{@link NetworkInformation}</li>
 *   <li>{@link ControllerInformation}</li>
 * </ul>
 *
 * @author Christian Ihle
 */
public class JMXAgent {

    /**
     * Default constructor. Registers the MBeans, and logs any failures.
     *
     * @param controller The controller.
     * @param connectionWorker The connection worker.
     */
    public JMXAgent(final Controller controller, final ConnectionWorker connectionWorker) {
        final Logger log = Logger.getLogger(JMXAgent.class.getName());
        final MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();

        try {
            // NetworkInformation MBean
            final ObjectName networkInfoName = new ObjectName(
                    Constants.APP_NAME + ":name=" + NetworkInformationMBean.NAME);
            platformMBeanServer.registerMBean(
                    new NetworkInformation(connectionWorker), networkInfoName);

            // ControllerInformation MBean
            final ObjectName controllerInfoName = new ObjectName(
                    Constants.APP_NAME + ":name=" + ControllerInformationMBean.NAME);
            platformMBeanServer.registerMBean(
                    new ControllerInformation(controller), controllerInfoName);

            // GeneralInformation MBean
            final ObjectName generalInfoName = new ObjectName(
                    Constants.APP_NAME + ":name=" + GeneralInformationMBean.NAME);
            platformMBeanServer.registerMBean(
                    new GeneralInformation(), generalInfoName);
        }

        catch (final MalformedObjectNameException e) {
            log.log(Level.SEVERE, e.toString(), e);
        }

        catch (final InstanceAlreadyExistsException e) {
            log.log(Level.SEVERE, e.toString(), e);
        }

        catch (final MBeanRegistrationException e) {
            log.log(Level.SEVERE, e.toString(), e);
        }

        catch (final NotCompliantMBeanException e) {
            log.log(Level.SEVERE, e.toString(), e);
        }
    }
}

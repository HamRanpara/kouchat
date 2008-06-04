
/***************************************************************************
 *   Copyright 2006-2008 by Christian Ihle                                 *
 *   kontakt@usikkert.net                                                  *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 *   This program is distributed in the hope that it will be useful,       *
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
 *   GNU General Public License for more details.                          *
 *                                                                         *
 *   You should have received a copy of the GNU General Public License     *
 *   along with this program; if not, write to the                         *
 *   Free Software Foundation, Inc.,                                       *
 *   59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.             *
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

import net.usikkert.kouchat.net.NetworkInformation;

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
 * </ul>
 *
 * @author Christian Ihle
 */
public class JMXAgent
{
	/** The logger. */
	private static final Logger LOG = Logger.getLogger( JMXAgent.class.getName() );

	/**
	 * Default constructor. Registers the MBeans, and logs any failures.
	 */
	public JMXAgent()
	{
		MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();

		try
		{
			// NetworkInformation MBean
			ObjectName networkInfoName = new ObjectName( "KouChat:name=Network" );
			platformMBeanServer.registerMBean( new NetworkInformation(), networkInfoName );
		}

		catch ( final MalformedObjectNameException e )
		{
			LOG.log( Level.SEVERE, e.toString(), e );
		}

		catch ( final InstanceAlreadyExistsException e )
		{
			LOG.log( Level.SEVERE, e.toString(), e );
		}

		catch ( final MBeanRegistrationException e )
		{
			LOG.log( Level.SEVERE, e.toString(), e );
		}

		catch ( final NotCompliantMBeanException e )
		{
			LOG.log( Level.SEVERE, e.toString(), e );
		}
	}
}


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

package net.usikkert.kouchat.misc;

import net.usikkert.kouchat.event.NickListListener;

/**
 * This is the interface used for keeping a list of the users
 * connected to the chat.
 *
 * <p>This is not a normal {@link List}, but the interface reminds of
 * one, so it can be used like a normal list. The reason a normal
 * list is not used instead is because of the need to notify of changes
 * to the list.</p>
 *
 * <p>The {@link List} interface is not extended because all the methods
 * there are not needed.</p>
 *
 * @author Christian Ihle
 */
public interface UserList
{
	/**
	 * Adds a user to the list, and notifies with {@link NickListListener#nickAdded(int)}.
	 *
	 * @param user The user to add.
	 * @return If the user was successfully added to the list.
	 */
	boolean add( User user );

	/**
	 * Gets the user at the specified position.
	 *
	 * @param pos The position to get the user.
	 * @return The user, or <code>null</code> of the user was not found.
	 */
	User get( int pos );

	/**
	 * Gets the position in the list where this user is located.
	 *
	 * @param user The user to locate the position of.
	 * @return The position, or -1 if not found.
	 */
	int indexOf( User user );

	/**
	 * Removes the user at the specified position from the list,
	 * and notifies with {@link NickListListener#nickRemoved(int)}.
	 *
	 * @param pos The position of the user to remove.
	 * @return The user that was removed.
	 */
	User remove( int pos );

	/**
	 * Removes the specified user from the list,
	 * and notifies with {@link NickListListener#nickRemoved(int)}.
	 *
	 * @param user The user to remove.
	 * @return If the user was successfully removed.
	 */
	boolean remove( User user );

	/**
	 * Sets the specified user at the specified position in the user list,
	 * and notifies with {@link NickListListener#nickChanged(int)}.
	 *
	 * @param pos The position to put the user.
	 * @param user The user to put in the position.
	 * @return The user that was previously in that position.
	 */
	User set( int pos, User user );

	/**
	 * Gets the number for users in the list.
	 *
	 * @return The number of users.
	 */
	int size();

	/**
	 * Adds a listener for changes to the user list.
	 *
	 * @param listener The listener to add.
	 */
	void addNickListListener( NickListListener listener );

	/**
	 * Removes a listener for changes to the user list.
	 *
	 * @param listener The listener to remove.
	 */
	void removeNickListListener( NickListListener listener );
}

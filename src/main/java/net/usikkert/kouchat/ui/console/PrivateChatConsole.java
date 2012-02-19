
/***************************************************************************
 *   Copyright 2006-2012 by Christian Ihle                                 *
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

package net.usikkert.kouchat.ui.console;

import net.usikkert.kouchat.misc.User;
import net.usikkert.kouchat.ui.PrivateChatWindow;

/**
 * Very simple console support for private chat sessions.
 *
 * @author Christian Ihle
 */
public class PrivateChatConsole implements PrivateChatWindow
{
    /** The user in this chat session. */
    private User user;

    /**
     * Constructor.
     *
     * @param user The user in this chat session.
     */
    public PrivateChatConsole(final User user)
    {
        this.user = user;
    }

    /**
     * Uses a simple System.out.println() to show messages,
     * with (privmsg) in front of them.
     *
     * @param message The private message to write to the console.
     * @param color The color of the message - not implemented.
     */
    @Override
    public void appendToPrivateChat(final String message, final int color)
    {
        System.out.println("(privmsg) " + message);
    }

    /**
     * Not implemented.
     */
    @Override
    public void clearChatText()
    {

    }

    /**
     * Will always return an empty string.
     *
     * {@inheritDoc}
     */
    @Override
    public String getChatText()
    {
        return "";
    }

    /**
     * Returns the user in this private chat.
     *
     * {@inheritDoc}
     */
    @Override
    public User getUser()
    {
        return user;
    }

    /**
     * Will always return true.
     *
     * {@inheritDoc}
     */
    @Override
    public boolean isVisible()
    {
        return true;
    }

    /**
     * Will always return true.
     *
     * {@inheritDoc}
     */
    @Override
    public boolean isFocused()
    {
        return true;
    }

    /**
     * Not implemented.
     *
     * {@inheritDoc}
     */
    @Override
    public void setAway(final boolean away)
    {

    }

    /**
     * Sets the user to null.
     *
     * {@inheritDoc}
     */
    @Override
    public void setLoggedOff()
    {
        user = null;
    }

    /**
     * Not implemented.
     *
     * {@inheritDoc}
     */
    @Override
    public void setVisible(final boolean visible)
    {

    }

    /**
     * Not implemented.
     *
     * {@inheritDoc}
     */
    @Override
    public void updateUserInformation()
    {

    }
}

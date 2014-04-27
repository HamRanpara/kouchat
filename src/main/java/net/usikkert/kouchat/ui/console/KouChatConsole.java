
/***************************************************************************
 *   Copyright 2006-2014 by Christian Ihle                                 *
 *   contact@kouchat.net                                                   *
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

import net.usikkert.kouchat.Constants;
import net.usikkert.kouchat.misc.Settings;

/**
 * Loads KouChat in console mode.
 *
 * @author Christian Ihle
 */
public class KouChatConsole {

    /**
     * Default constructor. Initializes the User Interface and
     * the necessary services.
     */
    public KouChatConsole() {
        System.setProperty(Constants.PROPERTY_CLIENT_UI, "Console");
        final Settings settings = new Settings();

        final ConsoleMediator mediator = new ConsoleMediator(settings);
        mediator.start();
    }
}

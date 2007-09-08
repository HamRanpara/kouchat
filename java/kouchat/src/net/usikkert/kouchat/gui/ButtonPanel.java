
/***************************************************************************
 *   Copyright 2006-2007 by Christian Ihle                                 *
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

package net.usikkert.kouchat.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel implements ActionListener
{
	private JButton minimizeB, clearB, awayB, topicB;
	private ListenerMediator listener;
	
	public ButtonPanel( ListenerMediator listener )
	{
		this.listener = listener;
		listener.setButtonP( this );
		
		setLayout( new GridLayout( 4, 1 ) );
		
		clearB = new JButton( "Clear" );
		clearB.addActionListener( this );
		add( clearB );
		
		awayB = new JButton( "Away" );
		awayB.addActionListener( this );
		add( awayB );
		
		topicB = new JButton( "Topic" );
		topicB.addActionListener( this );
		add( topicB );
		
		minimizeB = new JButton( "Minimize" );
		minimizeB.addActionListener( this );
		add( minimizeB );
		
		setBorder( BorderFactory.createEmptyBorder( 1, 1, 2, 1 ) );
	}
	
	public void setAwayState( boolean away )
	{
		topicB.setEnabled( !away );
	}

	@Override
	public void actionPerformed( ActionEvent e )
	{
		if ( e.getSource() == minimizeB )
		{
			listener.minimize();
		}
		
		else if ( e.getSource() == clearB )
		{
			listener.clearChat();
		}
		
		else if ( e.getSource() == awayB )
		{
			listener.setAway();
		}
		
		else if ( e.getSource() == topicB )
		{
			listener.setTopic();
		}
	}
}
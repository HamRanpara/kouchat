
package net.usikkert.kouchat.event;

public interface NickListListener
{
	public void nickAdded( int pos );
	public void nickChanged( int pos );
	public void nickRemoved( int pos );
}
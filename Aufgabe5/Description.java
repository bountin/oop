public class Description
	implements Shorter<Description>
{
	private String text;

	Description(String text)
	{
		this.text = text;
	}

	public String toString()
	{
		return text;
	}

	public int getLength()
	{
		return text.length();
	}

	public boolean shorter(Description other)
	{
		return getLength() < other.getLength();
	}
}

import java.lang.String;
import java.lang.System;

class Test
{

	public static void main(String[] args)
	{
		Bauarbeiter bau = new Bauarbeiter("1", new FesterSkin(), new SoftwareBauarbeiter(4));
		System.out.println(bau.check() == true);

		Bauarbeiter bau2 = new Bauarbeiter("1", new FesterSkin(), new SoftwareHilfskraft(2));
		System.out.println(bau2.check() == false);


	}
}

import java.lang.String;
import java.lang.System;
import java.util.LinkedList;

class Test
{

	public static void main(String[] args)
	{
		LinkedList<UmweltKomponente> kitlist1 = new LinkedList<UmweltKomponente>();
		SensorenAktorenKit kit1 = new SensorenAktorenKit(kitlist1);

		Bauarbeiter bau = new Bauarbeiter("1", new FesterSkin(), new SoftwareBauarbeiter(new Sicherheitsstufe4()), kit1);
		System.out.println(bau.check() == true);

		Bauarbeiter bau2 = new Bauarbeiter("1", new FesterSkin(), new SoftwareHilfskraft(new Sicherheitsstufe2()), kit1);
		System.out.println(bau2.check() == false);


	}
}

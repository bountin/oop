import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Autor("Martin")
/*
 * 'Wert' der Annotation enhaelt den Autorenvornamen des Erstellers der Methode bzw. der Klasse
 */
public @interface Autor {
	@Autor("Martin")
	String value();
}

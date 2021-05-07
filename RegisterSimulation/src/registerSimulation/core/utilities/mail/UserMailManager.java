package registerSimulation.core.utilities.mail;

import registerSimulation.business.constants.Environment;
import registerSimulation.model.concretes.User;

public class UserMailManager implements MailService {

	@Override
	public void send(User user) {
		 System.out.println( user.geteMail()+" hesab�na "+ Environment.url+ "link icerigi g�nderildi");
		
	}

}

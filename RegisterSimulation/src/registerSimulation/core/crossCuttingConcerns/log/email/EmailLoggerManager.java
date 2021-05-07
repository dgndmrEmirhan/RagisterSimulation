package registerSimulation.core.crossCuttingConcerns.log.email;

import registerSimulation.core.crossCuttingConcerns.log.LoggerService;
import registerSimulation.model.concretes.User;

public class EmailLoggerManager implements LoggerService{

	@Override
	public void add(User user) {
	System.out.println(user.getFirstName()+" : adl� ki�i mail �zerinden eklendi ");
		
	}

	@Override
	public void delete(User user) {
		System.out.println(user.getFirstName()+" : adl� ki�i mail �zerinden silindi ");
		
	}

	@Override
	public void update(User user) {
		System.out.println(user.getFirstName()+" : adl� ki�i mail �zerinden g�ncellendi ");
		
	}

}

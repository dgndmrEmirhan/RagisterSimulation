package registerSimulation.dataAccess.concretes.inMemory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import registerSimulation.dataAccess.abstracts.UserDao;
import registerSimulation.model.concretes.User;

public class InMemoryUserDao implements UserDao {

	public static List<User> users =new ArrayList<User>();

	public InMemoryUserDao() {
		
	}
	
	
	@Override
	public void add(User user) {
		// sim�le olarak database ekleme
		users.add(user);
	}

	@Override
	public void update(User user) {
		// sim�le databasede g�ncelleme
		User userToUpdate = getById(user.getId());
		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getLastName());

	}

	@Override
	public void delete(User user) {
			// sim�le databaseden silme
		User deletedUser = users.stream().filter(x -> x.getId() == user.getId()).findFirst().get();
		users.remove(deletedUser);

	}

	@Override

	public User getById(int id) {
		// idye g�re kullan�c� getirme
		return users.stream().filter(x -> x.getId() == id).findFirst().get();
	}

	@Override
	public User getByEmail(String email) {
			// E maile g�re kullan�c� getirme
		return users.stream().filter(user -> user.geteMail().equals(email)).findFirst().orElse(null);
	}

	@Override
	public User getEmailAndPassword(String email, String password) {
			// email ve password� e�le�en kullan�c�y� getirme
		for(User user : users) {
			if(user.geteMail() == email && user.getPassword() == password)
				return user;
		}
		return null;

	}

	@Override
	public List<String> getEmails() {
			// e mailsleri getirme
		List<String> emails = new ArrayList<String>();
		for(User user:users ) {
			emails.add(user.geteMail());
		}
		return emails;
	}

	@Override
	public boolean isMailMatched(User user) {
		//  e maille e�le�en olup olmad���n� kontrol etme
		return users.stream().anyMatch(mails->mails.geteMail() ==user.geteMail());
	}

	@Override
	public boolean isPassWordMatched(User user) {
		if(isMailMatched(user)) {
			return users.stream().anyMatch(users_->users_.getPassword().equals(user.getPassword()));
		}
		// passwordle e�le�en var m� diye kontrol etme
		return false;
	}

	@Override
	public User get(Predicate<User> predicate) {
		return this.users.stream().filter(predicate).findFirst().orElse(null);
	}

	@Override
	public List<User> getAll(Predicate<User> predicate) {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public List<User> getAll() {
		
		return this.users.stream().collect(Collectors.toList());
	}

}

package registerSimulation.googleAuthorization;

public class GoogleAuthorizationManager {

	public void register(String email, String password) {
		System.out.println(" google authorization kayd� ger�ekle�ti : " + email);
	}

	public boolean login(String email, String password) {
		System.out.println(" google ile login olundu : " + email);
		return true;
	}

	public void logOut(String email) {
		System.out.println("Google ile ��k�� yap�ld� : " + email);
	}

}

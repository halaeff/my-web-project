package by.gsu.epamlab.bean;

public enum Role {
	ADMIN, USER, VISITOR, FAKER;
	public static Role getRole(String login, String password, 
			String cmpLogin, String cmpPassword, Role role) {
		if (!cmpLogin.equals(login)) {
			return VISITOR;
		}
		if(!cmpPassword.equals(password)) {
			return FAKER;
		}
		return role;
	}
	public static Role getRole(String login, String password, 
			String cmpLogin, String cmpPassword, String strRole) {
		return getRole(login, password, cmpLogin, cmpPassword, valueOf(strRole));
	}
}
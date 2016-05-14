package lib;

public class User {
	
	    private String firstName;
	    private String lastName;
	    private String city;
	    private String email;
	    private String password;
	    private String repeatPassword;
	    
	    public User(String firstName, String lastName, String city, String email, String password) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.city = city;
	        this.email = email;
	        this.password = password;
	        this.repeatPassword = password;
	    }
	    
	    public User(String firstName, String lastName, String city, String email, String password, String repeatPassword) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.city = city;
	        this.email = email;
	        this.password = password;
	        this.repeatPassword = repeatPassword;
	    }

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public String getCity() {
			return city;
		}

		public String getEmail() {
			return email;
		}

		public String getPassword() {
			return password;
		}

		public String getRepeatPassword() {
			return repeatPassword;
		}
		
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		public void setRepeatPassword(String repeatPassword) {
			this.repeatPassword = repeatPassword;
		}
}

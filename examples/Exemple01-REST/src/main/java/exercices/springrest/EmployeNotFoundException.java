package exercices.springrest;

class EmployeNotFoundException extends RuntimeException {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

EmployeNotFoundException(Long id) {
    super("Could not find employee " + id);
  }
}
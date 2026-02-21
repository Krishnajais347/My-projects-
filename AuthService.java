import com.cloudfy.model.User;
import com.cloudfy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	@Autowired
	private UserRepository userRepository;

	public User register(User u) {
		// simple check: phone uniqueness
		if (userRepository.findByPhoneNumber(u.getPhoneNumber()) != null) {
			throw new RuntimeException("Phone already registered");
		}
		return userRepository.save(u);
	}

	public User login(String phone, String password) {
		User u = userRepository.findByPhoneNumber(phone);
		if (u == null)
			return null;
		if (!u.getPassword().equals(password))
			return null;
		return u;
	}
}
lsnfjsdf dsfbdf hfkf
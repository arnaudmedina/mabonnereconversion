package ecolededev.pe.account;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.transaction.annotation.Transactional;

import ecolededev.pe.domaine.CompetenceDetail;

import ecolededev.pe.domaine.DetailFormation;
import ecolededev.pe.domaine.ExperienceDetail;
import ecolededev.pe.domaine.Mobilite;
import ecolededev.pe.domaine.repository.ICompetenceDetailRepository;
import ecolededev.pe.domaine.repository.IDetailFormationRepository;
import ecolededev.pe.domaine.repository.IExperienceDetailRepository;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AccountService  implements UserDetailsService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private IDetailFormationRepository detailRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ICompetenceDetailRepository competenceDetailRepository;

	@Autowired
	private IExperienceDetailRepository experienceDetailRepository;
	
	@PostConstruct	
	protected void initialize() {
		//save(new Account("user", "demo", "ROLE_USER"));
		//save(new Account("admin", "admin", "ROLE_ADMIN"));
	}

	@Transactional
	public Account save(Account account) {
		if (account.getId() == null) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		}
		accountRepository.save(account);
		return account;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findOneByEmail(username);
		if(account == null) {
			throw new UsernameNotFoundException("user not found #001");
		}
		return createUser(account);
	}
	
	public Account loadUserByEmail(String email) throws UsernameNotFoundException {
		Account account = accountRepository.findOneByEmail(email);
		if(account == null) {
			throw new UsernameNotFoundException("user not found #002 for email : '" + email + "'");
		}
		return account;
	}
	
	public void signin(Account account) {
		SecurityContextHolder.getContext().setAuthentication(authenticate(account));
	}
	
	private Authentication authenticate(Account account) {
		return new UsernamePasswordAuthenticationToken(createUser(account), null, Collections.singleton(createAuthority(account)));		
	}
	
	private User createUser(Account account) {
		return new User(account.getEmail(), account.getPassword(), Collections.singleton(createAuthority(account)));
	}

	private GrantedAuthority createAuthority(Account account) {
		return new SimpleGrantedAuthority(account.getRole());
	}
		  
	public List<DetailFormation> listeFormation(Long userId){
	List<DetailFormation> res =  accountRepository.listeFormation(userId);
	return res;
	}
	
//	public DetailFormation ajouterFormation(DetailFormation formation) {
//		return detailRepository.save(formation); //sauvegarde d'une nouvelle formation pour un account donné
//	}

	public List<Mobilite> listeMobilites(Long userId){
		return accountRepository.listeMobilites(userId);
	}

	public List<CompetenceDetail> listeCompetences(Long id) {
		return accountRepository.listeCompetences(id);
	}

//	public CompetenceDetail ajouterCompetenceDetail(CompetenceDetail competenceDetail) {
//		return competenceDetailRepository.save(competenceDetail);
//	}
	public List<ExperienceDetail> listeExperiences(Long id) {
		return accountRepository.listeExperiences(id);
	}

//	public ExperienceDetail ajouterExperienceDetail(ExperienceDetail experienceDetail) {
//		return experienceDetailRepository.save(experienceDetail);
//	}

		
};

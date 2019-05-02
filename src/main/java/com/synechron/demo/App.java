package com.synechron.demo;

import java.util.HashSet;
import java.util.Set;

import com.synechron.demo.dao.impl.PanelDAOImp;
import com.synechron.demo.dao.impl.SkillDAOImpl;
import com.synechron.demo.dao.impl.UserDAOImp;
import com.synechron.demo.model.Panel;
import com.synechron.demo.model.Role;
import com.synechron.demo.model.Skill;
import com.synechron.demo.model.User;

public class App {
	
	public static void main( String[] args )
    {		
		
		
		UserDAOImp usrdaoimpl = new UserDAOImp();
		PanelDAOImp paneldaoimpl = new PanelDAOImp();
		SkillDAOImpl skilldaoimpl = new SkillDAOImpl();
		
//		testUpdateUser		
//		User usr1 = new User(61, null, null, "passWd");
//		usr1.setUsername("tasdwq");
//		usr1.setActiveUser(1);
//		usrdaoimpl.updateUser(usr1);
		
//		//Add Panel
		Panel pan1 = new Panel();
		pan1.setIdPanel(15);
		pan1.setUserId(5);
		pan1.setIdSyne(97);
		pan1.setNamePanel("pUpdate");
		pan1.setSurnamePanel("SurnameUPDATE");
		pan1.setPhone("32313");
		pan1.setEmailSyne("emailSyne@synechron.com");
		pan1.setDesignation("1");
		
		paneldaoimpl.updatePanel(pan1);
//		
		//Add Skill
//		Skill sk = new Skill(549, "oracaaaalce");
//		skilldaoimpl.addSkill(sk);
		
//		Set<Skill> skills = new HashSet<Skill>();
//		skills.add(sk);
	
//		pan1.setSkill(skills);	
//		
//		paneldaoimpl.addPanel(pan1);

//		Role rol1 = new Role();
//		rol1.setIdRole(3);
//		rol1.setNameRole("PanelhIBERNATE"); // notnull
		
//		
//		Role rol1 = new Role();
//		rol1.setIdRole(4);
//		rol1.setNameRole("rol2TestHibernate");
//		
//		Set <Role> roles = new HashSet<Role>();
//		roles.add(rol1);
//		usr3.setRole(roles);
//

//		testgetUserById
//		User usr2 = new User(60, null, null, null);
//		int idus = usr2.getIdUser();
//		System.out.println(usr2.getIdUser());
//		UserDAOImp usrdaoimpl = new UserDAOImp();
//		usrdaoimpl.getUserById(idus);
		
//		List
//		usrdaoimpl.getUsers();
//		paneldaoimpl.getPanels();
//		skilldaoimpl.getSkills();
		
    }
}

/**
 * 
 *   Coder              :       Akshay Pawar 
 * 
 *   Source Code        :       Take Details from User and Store it in a Database 
 * 
 *   Programming Level  :      Biginnar *  * Use Content:  Java - swing, mysql  
 * 
 *   IDE Used           :      Netbeans IDE 8.2
 *   
 *   Database Name      :      userdetail
 * 
 *   Tables (4) -       :      address, bank, interest, owner  
 * 
 *    Note: some private content include only for practice and coding purposes, and wants to be included more content in the form 
 *              like ATM No, ATM Pin etc
 * 
 * 
 * 
 * 
 */
package Registration;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class UserDetailsForm extends JFrame
{
    
    JLabel fname,lname,email,DOB,age,mobile,gender,lane,street,taluka,dist,state,country,bankname,holdername,accno,branch,ifsc,atm,pin,actor,actress,movie,game,socialmedia,car;
    JTextField fnameText,lnameText,emailText,mobileText,laneText,streetText,talukaText,distText,banknameText,holdernameText,accnoText,branchText,ifsctext,atmText,movieText;
    JPasswordField pinText;
    String[] st = {"Select State","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chattisgarh","Goa","Gujrat","Haryana","Himachal Pradesh","J & K","Jharkhand","Karnataka","Kerala","madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisa","Panjab","Rajastan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};
    String[] cntry = {"Select Country","Afganistan","Africa","Albania","Algeria","Andorra","Angola","Argentina","Armenia","Australia","Azerbaijan","Bahamas","Barbados","Belarus","Belgium","Belize","Benin","Bhatan","Bolivia","Botswana","Brazil","Brunei","Bulgeria","Burkina Faso","Burundi","Cambodia","Cameroon","Canada","Chad","Chile","China","Colombia",
                    "Comoros","Cuba","Denmark","Djibouti","Ecuador","Egypt","Eritrea","Estonia","Fiji","Finland","France","Gabon","Georgia","Germany","Ghana","Greece","Grenada","Gautemala","Guinea","Guyana","Haiti","Honduras","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Israel","Itly","Jamaika","Japan","Jorden","Kazakistan","Kenya","Kiribati","Korea,North","Korea,South","Kosovo","Kuwait",
                     "Laos","latvia","Labenon","Lesotho","Liberia","Libya","Luxembourg","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Malta","Mauritania","Maxico","Moldova","Monaco","Mongolia","Morocco","Myanmar", "Namibia","Nauru","Nepal","Netherland","New Zeland","Niger","Norway","Oman","Pakistan","Palau","Panama","Paraguay","Peru","Philippines","poland","Portugal","Qatar","Romania","Russia","Rwanda","Saint Lucia",
                    "Samoa","San Marino","Saudi Arebia","senegal","Serbia","Singapore","Slovakia","Slovenia","Solomon","Sauth Africa","Spain","Sri Lanka","Sudan","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikstan","Thailand","Togo","Tonga","Tunisia","Turkey","Uganda","Vanuatu","Vietnam","Yemen","Zambia","Zimbabwe"};
    String[] ag = {"10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70"};
    String[] actorlist = {"Select Actor","Abhishekh Bachchan","Ajay Deogan","Akshay Kumar","Amir Khan","Amitabh Bachchan","Amjad Khan","Amoil Palekar","Amrish Puri","Anil Kappr","Anumpam Kher","Arjun Rampal","Arshad Warsi","Ashok Kumar","Bobby Deol","Boman Irani","Chunky Pandey","Dev Anand","Dharmendra","Dilip Kumar","Emraan Hashmi","Faran Aktar","Firoz Khan","Govinda","Guru Datt","Hritik Roshan","Irrfan Khan","Jackie Shroff","javed Jaffrey","Jeetendra","Johnny Lever","kadar Khan","Kamal Hasan",
                        "Kishor Kumar","Madhvan","Manoj Bajpayee","manoj Kumar","Mithun Chakraborty","Nana Patekar","Naseeruddin Shah","Nawazuddin Siddiqui","Om Puri","Pankaj Kapoor","Paresh Raval","Prem Chopra","Raaj Kumar","Rajanikanth","Raj Babbar","Rajesh Khanna","Raj Kapoor","Rajpal Yadav","Rakesh Roshan","Ranbir Kapoor","Ranvir Sign", "Ritesh Deshmukh","Rushi Kapoor","Saif Ali Khan","Salman Khan","Sanjay Datt","Sanjeev Kumar","Saurabh Shukla","Shahid Kapoor","Shah Rukh Khan","Shakti Kapoor",
                        "Shammi Kapoor","Shashi Kapoor","Shatrughan Sinha","Sunil Datt","Sunil Shetty","Sunny Deol","Vinod Khanna"};
    String[] acctresslist = {"Select Actress","Aditi Rao Hydari","Aishwarya Rai","Alia Bhatt","Ameesha Patel","Amrita Rao","Anushka Sharma","Asin","Bipasha Basu","Chitrangda Singh"," Daisy Shah","Deepika Padukone","Dia Mirza","Esha Gupta","Genelia D'Souza","Huma Qureshi","Ileana D'Cruz","Jacqueline Fernandez","Kajal Aggarwal","Kajol","Kalki Koechlin","Kangana Ranaut",
                    "Kareena Kapoor","Katrina Kaif","Kriti Sanon"," Lauren Gottlieb","Lisa Haydon","Madhuri Dixit","Malaika Arora","Mallika Sherawat","Nargis Fakhri","Parineeti Chopra","Preity Zinta","Priyanka Chopra","Rani Mukerji","Richa Chadha","Sana Khaan","Shilpa Shetty","Shraddha Kapoor","Sonakshi Sinha","Sonam Kapoor","Sridevi","Sunny Leone","Surveen Chawla","Twinkle Khanna","Vaani Kapoor","Vidya Balan","Yami Gautam","Zareen Khan"};
    
    String[] gamelist = {"Select Sport's","Archery","Badminton","Baseball ","Basketball","Beach Volleyball","Boxing","Climbing","Cricket","Cycling ","Diving","Fencing","Field Hockey","Football","Golf","Gymnastics","Handball","Judo","Jumping","Karate","Modern Pentathlon","Roller Sport","Rowing","Rugby 7s","Sailing","Shooting","Softball","Surfing","Swimming","Synchronized Swimming","Table Tennis","Taekwondo","Tennis","Track and Field","Triathlon","Volleyball","Water Polo","Weightlifting","Wrestling"};
    String[] socialmedialist = {"Select Social Media","AngelList ","badoo","Dig","Facebook","Flipboard","Foursquare","Gab","GirlsAskGuys","Google+","Instagram ","Kickstarter ","KiwiBox","Line","LinkedIn", "Medium","MeetMe","MeetUp","Messenger","MySpace","Nextdoor ","Pinboard","Pinterest","ProductHunt ","Quora","Reddit","Skype","SkyRock","Snapchat","Stumbleupon	","Tagged","Telegram","Tinder", "TripAdvisor" ,"Tumblr", "Tumblr","Twitter","Twoo","Viber","VK","WeChat","WhatsApp","WordPress","Yelp","YouTube", "Zomato"};
    String[] carlist = {"Select Car's","Aston Martin","Audi","BAIC","Bentley","BMW","BYD","Chery","Chevrolet","Chrysler","Dodge","FAW","Ferrari","Ford","FOTON","GAZ","Greely","Great Wall","Haima","Honda","Hyundai","Isuzu","JAC","Jaguar","Jeep","JMC","Kia","King Long","Lamborghini","Land Rover","Lexus","Lifan","Lotus","Mahindra","Maserati","Mazda","Mercedes-Benz","MG","Mini","Mitsubishi","Morgan","Nissan","Peugeot","porsche","Rolls-Royal","SsangYong","Subaru","Suzuki","TATA","Toyota","Volkswagen","Volvo"};
    JButton submit,cancel;
    
    JComboBox stateText,countryText,ageText,actorCombo,actressCombo,gameCombo,socialCombo,carsCombo;
    public UserDetailsForm() throws Exception
    {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        Font f = new Font("Times New Roman",Font.ITALIC,30);
        JFrame j = new JFrame("Registration Form");
        JLabel head = new JLabel("Registration Detail's");
        head.setBounds(230, 10, 300, 35);
        head.setForeground(Color.red);
        head.setFont(f);
        j.add(head);
        j.setLayout(null);
        j.setLocationRelativeTo(null);
        j.setBounds(350, 5, 700, 760);
        
        
        JPanel panel = new JPanel(null);
       // panel.setBounds(100, 50, 600, 500);
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(500, 2000));
        
        
        
        Font ft = new Font("Times New Roman",Font.PLAIN,20);
        //_______________________________________________________________________________________
        fname = new JLabel("First Name : ");
        fname.setBounds(50, 20, 120, 30);
        fname.setFont(ft);
        panel.add(fname);
        
        fnameText = new JTextField();
        fnameText.setBounds(180, 20, 150, 30);
        fnameText.setFont(ft);
        panel.add(fnameText);
        //_______________________________________________________________________________________
        
        lname = new JLabel("Last Name : ");
        lname.setBounds(50, 80, 120, 30);
        lname.setFont(ft);
        panel.add(lname);
        
        lnameText = new JTextField();
        lnameText.setBounds(180, 80, 150, 30);
        lnameText.setFont(ft);
        panel.add(lnameText);
        
        //_______________________________________________________________________________________
        
        email = new JLabel("Email ID : ");
        email.setBounds(50, 140, 150, 30);
        email.setFont(ft);
        panel.add(email);
        
        emailText = new JTextField();
        emailText.setBounds(180, 140, 250, 30);
        emailText.setFont(ft);
        panel.add(emailText);
        //_______________________________________________________________________________________
        
        age = new JLabel("Age : ");
        age.setBounds(50, 200, 100, 30);
        age.setFont(ft);
        panel.add(age);
        
        ageText = new JComboBox(ag);
        ageText.setBounds(180, 200, 80, 30);
        ageText.setFont(ft);
        panel.add(ageText);
        
        //_______________________________________________________________________________________
        
        mobile = new JLabel("Mobile No :");
        mobile.setBounds(50, 260, 100, 30);
        mobile.setFont(ft);
        panel.add(mobile);
        
        mobileText = new JTextField();
        mobileText.setBounds(180, 260, 150, 30);
        mobileText.setFont(ft);
        panel.add(mobileText);
        
        
        //_______________________________________________________________________________________
        
        gender = new JLabel("Gender : ");
        gender.setBounds(50, 320, 100, 30);
        gender.setFont(ft);
        panel.add(gender);
        
        ButtonGroup grp = new ButtonGroup();
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(180, 320, 70, 30);
        male.setFont(ft);
        JRadioButton female = new JRadioButton("Female");
        female.setFont(ft);
        female.setBounds(280, 320, 80, 30);
        grp.add(male);grp.add(female);
        panel.add(male);panel.add(female);
        
        JSeparator sp = new JSeparator(JSeparator.HORIZONTAL);
        sp.setBounds(50, 380, 400, 30);
        panel.add(sp);
        //_______________________________________________________________________________________
        
        JLabel head2 = new JLabel("Address Details");
        head2.setBounds(150, 400, 300, 35);
        head2.setFont(f);
        head2.setForeground(Color.RED);
        panel.add(head2);
        
        //_______________________________________________________________________________________
        
        lane = new JLabel("Lane : ");
        lane.setBounds(50, 460, 100, 30);
        lane.setFont(ft);
        panel.add(lane);

        laneText = new JTextField();
        laneText.setBounds(180, 460, 200, 30);
        laneText.setFont(ft);
        panel.add(laneText);
        
        //_______________________________________________________________________________________
        
        street = new JLabel("Street : ");
        street.setBounds(50, 520, 100, 30);
        street.setFont(ft);
        panel.add(street);
        
        streetText = new JTextField();
        streetText.setBounds(180, 520, 200, 30);
        streetText.setFont(ft);
        panel.add(streetText);
        
        //_______________________________________________________________________________________
        
        taluka = new JLabel("Taluka : ");
        taluka.setBounds(50, 580, 100, 30);
        taluka.setFont(ft);
        panel.add(taluka);
        
        talukaText = new JTextField();
        talukaText.setBounds(180, 580, 150, 30);
        talukaText.setFont(ft);
        panel.add(talukaText);
        
        //_______________________________________________________________________________________
        
        dist = new JLabel("District : ");
        dist.setBounds(50, 640, 100, 30);
        dist.setFont(ft);
        panel.add(dist);
        
        distText = new JTextField();
        distText.setBounds(180, 640, 150, 30);
        distText.setFont(ft);
        panel.add(distText);
        
        //_______________________________________________________________________________________
        
        state = new JLabel("State : ");
        state.setBounds(50, 700, 100, 30);
        state.setFont(ft);
        panel.add(state);
        
        stateText = new JComboBox(st);
        stateText.setBounds(180, 700, 180, 30);
        stateText.setFont(ft);
        panel.add(stateText);
        
        
        //_______________________________________________________________________________________
        
        country = new JLabel("Country : ");
        country.setBounds(50, 760, 100, 30);
        country.setFont(ft);
        panel.add(country);
        
        countryText = new JComboBox(cntry);
        countryText.setBounds(180, 760, 180, 30);
        countryText.setFont(ft);
        panel.add(countryText);
        
        //_______________________________________________________________________________________
        JSeparator sp1 = new JSeparator(JSeparator.HORIZONTAL);
        sp1.setBounds(50, 820, 400, 30);
        panel.add(sp1);
            
        //_______________________________________________________________________________________
        
        JLabel head3 = new JLabel("Bank Details");
        head3.setBounds(150, 840, 300, 35);
        head3.setFont(f);
        head3.setForeground(Color.RED);
        panel.add(head3);
        //_______________________________________________________________________________________
        
        bankname = new JLabel("Bank Name : ");
        bankname.setBounds(50, 900, 120, 30);
        bankname.setFont(ft);
        panel.add(bankname);
        
        banknameText = new JTextField();
        banknameText.setBounds(180, 900, 180, 30);
        banknameText.setFont(ft);
        panel.add(banknameText);
        
        //_______________________________________________________________________________________
        
        holdername = new JLabel("Acc. Holder : ");
        holdername.setBounds(50, 960, 170, 30);
        holdername.setFont(ft);
        panel.add(holdername);
        
        holdernameText = new JTextField();
        holdernameText.setBounds(180, 960, 220, 30);
        holdernameText.setFont(ft);
        panel.add(holdernameText);
        //_______________________________________________________________________________________
        
        accno = new JLabel("Account No : ");
        accno.setBounds(50, 1020, 120, 30);
        accno.setFont(ft);
        panel.add(accno);
        
        accnoText = new JTextField();
        accnoText.setBounds(180, 1020, 200, 30);
        accnoText.setFont(ft);
        panel.add(accnoText);
        
        //_______________________________________________________________________________________
        
        branch = new JLabel("Branch : ");
        branch.setBounds(50, 1080, 100, 30);
        branch.setFont(ft);
        panel.add(branch);
        
        branchText = new JTextField();
        branchText.setBounds(180, 1080, 180, 30);
        branchText.setFont(ft);
        panel.add(branchText);
        
        //_______________________________________________________________________________________
        
        ifsc = new JLabel("IFSC Code : ");
        ifsc.setBounds(50, 1140, 120, 30);
        ifsc.setFont(ft);
        panel.add(ifsc);
        
        ifsctext = new JTextField();
        ifsctext.setBounds(180, 1140, 150, 30);
        ifsctext.setFont(ft);
        panel.add(ifsctext);
        
        //_______________________________________________________________________________________
        
        atm = new JLabel("ATM No : ");
        atm.setBounds(50, 1200, 100, 30);
        atm.setFont(ft);
        panel.add(atm);
        
        atmText = new JTextField();
        atmText.setBounds(180, 1200, 180, 30);
        atmText.setFont(ft);
        panel.add(atmText);
        //_______________________________________________________________________________________
        pin = new JLabel("ATM Pin : ");
        pin.setBounds(50, 1260, 100, 30);
        pin.setFont(ft);
        panel.add(pin);
        
        pinText = new JPasswordField();
        pinText.setBounds(180, 1260, 80, 30);
        pinText.setFont(ft);
        panel.add(pinText);
        
        //_______________________________________________________________________________________
        
        JSeparator sp2 = new JSeparator(JSeparator.HORIZONTAL);
        sp2.setBounds(50, 1320, 400, 30);
        panel.add(sp2);
        
        //_______________________________________________________________________________________
        
        JLabel head4 = new JLabel("Likes");
        head4.setBounds(200, 1340, 300, 35);
        head4.setFont(f);
        head4.setForeground(Color.RED);
        panel.add(head4);
        //_______________________________________________________________________________________ 
        
        actor = new JLabel("Actor : ");
        actor.setBounds(50, 1400, 100, 30);
        actor.setFont(ft);
        panel.add(actor);
        
        actorCombo = new JComboBox(actorlist);
        actorCombo.setBounds(180, 1400, 200, 30);
        actorCombo.setFont(ft);
        panel.add(actorCombo);
        
        
        //_______________________________________________________________________________________ 
        
        actress = new JLabel("Actress  : ");
        actress.setBounds(50, 1460, 100, 30);
        actress.setFont(ft);
        panel.add(actress);
        
        actressCombo = new JComboBox(acctresslist);
        actressCombo.setBounds(180, 1460, 200, 30);
        actressCombo.setFont(ft);
        panel.add(actressCombo);
        
        //_______________________________________________________________________________________
        
        movie = new JLabel("Movie : ");
        movie.setBounds(50, 1520, 100, 30);
        movie.setFont(ft);
        panel.add(movie);
        
        movieText = new JTextField();
        movieText.setBounds(180, 1520, 200, 30);
        movieText.setFont(ft);
        panel.add(movieText);
        
        //_______________________________________________________________________________________
        
        game = new JLabel("Sport's : ");
        game.setBounds(50, 1580, 150, 30);
        game.setFont(ft);
        panel.add(game);
        
        gameCombo = new JComboBox(gamelist);
        gameCombo.setBounds(180, 1580, 200, 30);
        gameCombo.setFont(ft);
        panel.add(gameCombo);
        
        //_______________________________________________________________________________________
        
        socialmedia = new JLabel("Social Media : ");
        socialmedia.setBounds(50, 1640, 150, 30);
        socialmedia.setFont(ft);
        panel.add(socialmedia);
        
        socialCombo = new JComboBox(socialmedialist);
        socialCombo.setBounds(180, 1640, 200, 30);
        socialCombo.setFont(ft);
        panel.add(socialCombo);
        //_______________________________________________________________________________________
        
        car = new JLabel("Car's : ");
        car.setBounds(50, 1700, 150, 30);
        car.setFont(ft);
        panel.add(car);
        
        carsCombo = new JComboBox(carlist);
        carsCombo.setBounds(180, 1700, 200, 30);
        carsCombo.setFont(ft);
        panel.add(carsCombo);
                

        //_______________________________________________________________________________________
        
            
        //_______________________________________________________________________________________
        
        
        
        JScrollPane scroll = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(100,50,500,670);
        j.add(scroll);
        
        JSeparator sp3 = new JSeparator(JSeparator.HORIZONTAL);
        sp3.setBounds(50, 1760, 400, 30);
        panel.add(sp3);
        
        submit = new JButton("Register");
        submit.setBackground(Color.WHITE);
        submit.setBounds(80, 1800, 150, 50);
        submit.setFont(ft);
        panel.add(submit);
                
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.red);
        cancel.setBackground(Color.WHITE);
        cancel.setBounds(260, 1800, 150, 50);
        cancel.setFont(ft);
        panel.add(cancel);
        
        
        j.setDefaultCloseOperation(EXIT_ON_CLOSE);
        j.setResizable(false);
        j.setVisible(true);
        
        submit.addActionListener((ActionEvent e) -> 
        {
            try {
                String Fname = fnameText.getText();
                String Lname = lnameText.getText();
                String Email = emailText.getText();
                String Age = (String)ageText.getSelectedItem();
                Long mob = Long.parseLong(mobileText.getText());
                String gend;
                if(male.isSelected())
                {
                    gend = male.getText();
                }
                else
                {
                    gend = female.getText();
                }
                
                //______________________________________________________________
                
                String Lane = laneText.getText();
                String Street = streetText.getText();
                String Tal = talukaText.getText();
                String Dist = distText.getText();
                String State = (String)stateText.getSelectedItem();
                String Country = (String)countryText.getSelectedItem();
                //______________________________________________________________
                
                String Bank = banknameText.getText();
                String AccHolderName = holdernameText.getText();
                Long accNo = Long.parseLong(accnoText.getText());
                String Branch = branchText.getText();
                String IFSC = ifsctext.getText();
                Long atmNo = Long.parseLong(atmText.getText());
                int Pin = Integer.parseInt(pinText.getText());
                //______________________________________________________________
                
                String Actor = (String)actorCombo.getSelectedItem();
                String Actress = (String)actressCombo.getSelectedItem();
                String Movie = movieText.getText();
                String Game = (String)gameCombo.getSelectedItem();
                String SocialMedia = (String)socialCombo.getSelectedItem();
                String Car = (String)carsCombo.getSelectedItem();
                
                String url = "jdbc:mysql://localhost/userdetail";
                String user = "root";
                String pass = "Akshay";
                String ownquery = "insert into owner value(?,?,?,?,?,?)";
                String addquery = "insert into address value(?,?,?,?,?,?)";
                String bankquery = "insert into bank value(?,?,?,?,?,?,?)";
                String intrestquery = "insert into intrest value(?,?,?,?,?,?)";
                
                Connection c = DriverManager.getConnection(url,user,pass);
                Statement s = c.createStatement();
                
                PreparedStatement ps1 = c.prepareStatement(ownquery);
                ps1.setString(1, Fname);
                ps1.setString(2, Lname);
                ps1.setString(3, Email);
                ps1.setString(4, Age);
                ps1.setLong(5, mob);
                ps1.setString(6, gend);
                int r1 = ps1.executeUpdate();
                //_____________________________________________________________
                PreparedStatement ps2 = c.prepareStatement(addquery);
                ps2.setString(1, Lane);
                ps2.setString(2, Street);
                ps2.setString(3, Tal);
                ps2.setString(4, Dist);
                ps2.setString(5, State);
                ps2.setString(6, Country);
                int r2 = ps2.executeUpdate();
                //____________________________________________________________
                PreparedStatement ps3 = c.prepareStatement(bankquery);
                ps3.setString(1, Bank);
                ps3.setString(2, AccHolderName);
                ps3.setLong(3, accNo);
                ps3.setString(4, Branch);
                ps3.setString(5, IFSC);
                ps3.setLong(6, atmNo);
                ps3.setInt(7, Pin);
                int r3 = ps3.executeUpdate();
                //____________________________________________________________
                PreparedStatement ps4 = c.prepareStatement(intrestquery);
                ps4.setString(1, Actor);
                ps4.setString(2, Actress);
                ps4.setString(3, Movie);
                ps4.setString(4,Game);
                ps4.setString(5, SocialMedia);
                ps4.setString(6, Car);
                int r4 = ps4.executeUpdate();
                //____________________________________________________________
                
                
                
            } catch (SQLException s){s.printStackTrace();}
            
            JOptionPane.showMessageDialog(j, "Thanks for Subscribing...");
            j.dispose();
        });
        
        cancel.addActionListener((ActionEvent e) -> 
        {
            JOptionPane.showMessageDialog(j, "Thanks for Visiting...");
            j.dispose();
        });
        
        
    }

    
     public static void main(String[] args) throws Exception
    {
        UserDetailsForm o = new UserDetailsForm();
    }
}

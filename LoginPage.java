import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.net.*;
import javax.imageio.*;
import java.util.*;
import java.io.*;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.PreparedStatement;

import javax.swing.text.*;

public class LoginPage extends JFrame
{
	Container c = getContentPane();
	JPanel PFlightTypes = new JPanel(null);
	JPanel PLogin = new JPanel(null);
	JPanel PFlightDetails = new JPanel(null);

	public boolean bCheck=true;

	JLabel LDomesticFlight = new JLabel("<html><b>Domestic Flights</b></html>");
	JLabel LInternationalFlight = new JLabel("<html><b>International Flights</b></html>");

	JLabel LUserName, LPassword;

	JButton LDomesticFlight1 = new JButton("<html><b>Domestic Flight Booking</b></html>");
	JButton LInternationalFlight1 = new JButton("<html><b>International Flight Booking</b></html>");
	JButton LAdminPanel = new JButton("Administrator Panel");

	JLabel LDivideBooking = new JLabel("<html><i>Select booking method to purchase ticket(s).</i></html>");
	JLabel LDivideFlights = new JLabel("<html><i>Select flight type to view flight listings.</i></html>");
	JLabel LTableTitle = new JLabel("<html><b>Flight Listings</b></html>");
	JLabel LChooseClass = new JLabel("<----- Choose a flight class");

	JTextField TFUserName;
	JPasswordField TPPassword;

	JButton BLogin;

	final Object[] col1 ={ "From", "To", "Price", "Time" };
	final Object[] col2 = { "From", "To", "Price", "Time" };
	final Object[] col3 = { "From", "To", "Price", "Time" };

	//domestic economy
//	final Object[][] row1 = { { "Phoenix", "San Diego", "220", "16:30" }, { "Phoenix", "Ontario ", "250", "19:00" }, { "Phoenix", "Burbank", "280", "08:30" }, { "Phoenix", "Los Angeles", "260", "09:50" }, { "Phoenix", "Orange County", "245", "11:00" }, { "Phoenix", "Las Vegas", "170", "05:30" }, { "Phoenix", "San Jose", "180", "05:30" }, { "Phoenix", "San Francisco", "260", "12:00" }, { "Phoenix", "Oakland", "320", "19:00" } };
	final ArrayList<Object[]> row1 = new ArrayList<Object[]>();

	//domestic business
//	final Object[][] row3 = { { "Phoenix", "San Diego", "420", "16:30" }, { "Phoenix", "Ontario ", "450", "19:00" }, { "Phoenix", "Burbank", "480", "08:30" }, { "Phoenix", "Los Angeles", "460", "09:50" }, { "Phoenix", "Orange County", "445", "11:00" }, { "Phoenix", "Las Vegas", "370", "05:30" }, { "Phoenix", "San Jose", "380", "05:30" }, { "Phoenix", "San Francisco", "460", "12:00" }, { "Phoenix", "Oakland", "520", "19:00" } };
	final ArrayList<Object[]> row3 = new ArrayList<Object[]>();
	
	//international economy
//	final Object[][] row2 = { { "Phoenix", "London", "1500", "06:20" }, { "Phoenix", "Rome", "2200", "20:45" }, { "Phoenix", "Frankfurt", "1350", "10:25" }, { "Phoenix", "Tokyo", "2300", "16:45" }, { "Phoenix", "Manila", "2100", "06:30" }, { "Phoenix", "Madrid", "1550", "08:15" }, { "Phoenix", "Beijing", "2400", "06:50" }, { "Phoenix", "Shanghai", "2545", "12:00" }, { "Phoenix", "Paris", "1300", "10:45" }, { "Phoenix", "Barcelona", "1200", "14:35" }, { "Phoenix", "Hong Kong", "1500", "22:00" }, { "Phoenix", "Singapore", "1780", "21:15" }, { "Phoenix", "Cancun", "750", "08:50" }, { "Phoenix", "Montreal", "1720", "18:45" }, { "Phoenix", "Istanbul", "1390", "20:00"}, { "Phoenix", "Munich", "900", "12:00"}, { "Phoenix", "Amsterdam", "1240", "10:15" }, { "Phoenix", "Dubai", "1290", "21:10" }, { "Phoenix", "Toronto", "780", "12:00"}, { "Phoenix", "Mumbai", "2300", "17:00" } };
	final ArrayList<Object[]> row2 = new ArrayList<Object[]>();
			
	//international business
//	final Object[][] row4 = { { "Phoenix", "London", "2500", "06:20" }, { "Phoenix", "Rome", "3200", "20:45" }, { "Phoenix", "Frankfurt", "2350", "10:25" }, { "Phoenix", "Tokyo", "3300", "16:45" }, { "Phoenix", "Manila", "3100", "06:30" }, { "Phoenix", "Madrid", "2550", "08:15" }, { "Phoenix", "Beijing", "3400", "06:50" }, { "Phoenix", "Shanghai", "3545", "12:00" }, { "Phoenix", "Paris", "2300", "10:45" }, { "Phoenix", "Barcelona", "2200", "14:35" }, { "Phoenix", "Hong Kong", "2500", "22:00" }, { "Phoenix", "Singapore", "2780", "21:15" }, { "Phoenix", "Cancun", "1750", "08:50" }, { "Phoenix", "Montreal", "2720", "18:45" }, { "Phoenix", "Istanbul", "2390", "20:00"}, { "Phoenix", "Munich", "1900", "12:00"}, { "Phoenix", "Amsterdam", "2240", "10:15" }, { "Phoenix", "Dubai", "2290", "21:10" }, { "Phoenix", "Toronto", "1780", "12:00"}, { "Phoenix", "Mumbai", "3300", "17:00" } };
	final ArrayList<Object[]> row4 = new ArrayList<Object[]>();

	JTable TDomesticFlight = new JTable(row1.toArray(new Object[row1.size()][]), col1);
	JTable TInternationalFlight = new JTable(row2.toArray(new Object[row2.size()][]), col2);
	JTable TDomesticFlight1 = new JTable(row3.toArray(new Object[row3.size()][]), col3);
	JTable TInternationalFlight1 = new JTable(row4.toArray(new Object[row4.size()][]), col2);

	JScrollPane JSP1 = new JScrollPane(TDomesticFlight, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JScrollPane JSP2 = new JScrollPane(TInternationalFlight, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JScrollPane JSP3 = new JScrollPane(TDomesticFlight1, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JScrollPane JSP4 = new JScrollPane(TInternationalFlight1, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	Icon img1 = null;
	Icon img2 = null;
//	Icon img1 = new ImageIcon(ecBI);
//
//	Icon img2 = new ImageIcon(busBI);
//	Icon img3 = new ImageIcon("img/economic1.jpg");
//	Icon img4 = new ImageIcon("img/business1.jpg");

	JLabel LEconomic = null;
	JLabel LBusiness = null;
//	JLabel LEconomic1 = new JLabel("Economic", img3, SwingConstants.LEFT);
//	JLabel LBusiness1 = new JLabel("Business", img4, SwingConstants.LEFT);

//	JLabel LEconomic = new JLabel("Economic");
//	JLabel LBusiness = new JLabel("Business");
	JLabel LEconomic1 = new JLabel("Economic");
	JLabel LBusiness1 = new JLabel("Business");

	public LoginPage()
	{
		WindowUtilities.setNativeLookAndFeel();
		setPreferredSize(new Dimension(796,572));

		try {
			URL deURL = new URL("http", "ec2-54-201-6-28.us-west-2.compute.amazonaws.com", 80, "/FlyHighBooking/de.txt");
	
			HttpURLConnection conn = (HttpURLConnection)deURL.openConnection();
			BufferedReader resp = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while (resp.ready())
			{
				row1.add(resp.readLine().split("\t"));
			}
			System.out.println(row1);
			resp.close();
		} catch (Exception exc) {
			System.out.println(exc);
		}
		

		PFlightTypes.setBackground(Color.white);
		PLogin.setBackground(Color.white);
		PFlightDetails.setBackground(Color.white);

		JSP1.setBounds(0, 340, 790, 200);
		JSP2.setBounds(0, 340, 790, 200);
		JSP3.setBounds(0, 340, 790, 200);
		JSP4.setBounds(0, 340, 790, 200);

		PFlightTypes.setBounds(0,0,500, 340);
		PLogin.setBounds(500,0,350, 340);
		PFlightDetails.setBounds(0,340,790,200);

		LUserName = new JLabel("User Name ");
		LPassword = new JLabel("Password ");
		TFUserName = new JTextField(10);
		TPPassword = new JPasswordField(10);
		BLogin = new JButton("Sign In");

		LUserName.setBounds(40, 100, 100, 21);
		LPassword.setBounds(40, 140, 100, 21);
		TFUserName.setBounds(160, 100, 100, 21);
		TPPassword.setBounds(160, 140, 100, 21);
		BLogin.setBounds(160, 200, 100,25);

		LDomesticFlight1.setBounds(60, 85, 235, 30);
		LDivideBooking.setBounds(10, 125, 350, 15);
		LInternationalFlight1.setBounds(60, 150, 235, 30);
		LAdminPanel.setBounds(60, 200, 235, 30);

		LChooseClass.setBounds(0,230,250,15);
		LChooseClass.setVisible(false);
        
		PLogin.add(LUserName);
		PLogin.add(TFUserName);
		PLogin.add(LPassword);
		PLogin.add(TPPassword);
		PLogin.add(BLogin);

		PFlightDetails.add(JSP1);
		PFlightDetails.add(JSP2);
		PFlightDetails.add(JSP3);
		PFlightDetails.add(JSP4);

		JSP1.setVisible(true);
		JSP2.setVisible(false);
		JSP3.setVisible(false);
		JSP4.setVisible(false);

		BufferedImage ecBI = null;
		try
		{
			URL u = new URL("http", "ec2-54-201-6-28.us-west-2.compute.amazonaws.com",80,"/FlyHighBooking/img/economic.jpg");
			System.out.println(u);
			ecBI = ImageIO.read(u);
		} catch (Exception exc) {
			System.out.println(exc);
		}
		img1 = new ImageIcon(ecBI);
		LEconomic = new JLabel("Economic", img1, SwingConstants.LEFT);

		BufferedImage busBI = null;
		try
		{
			URL u = new URL("http", "ec2-54-201-6-28.us-west-2.compute.amazonaws.com",80,"/FlyHighBooking/img/business.jpg");
			System.out.println(u);
			busBI = ImageIO.read(u);
		} catch (Exception exc) {
			System.out.println(exc);
		}
		img2 = new ImageIcon(busBI);
		LBusiness = new JLabel("Business", img2, SwingConstants.LEFT);

		LBusiness.setBounds(265, 170, 300, 125);
		LEconomic.setBounds(0, 170, 300, 125);
		LBusiness1.setBounds(280, 200, 135, 60);
		LEconomic1.setBounds(50, 200, 147, 60);

		PFlightTypes.add(LTableTitle);
		PFlightTypes.add(LEconomic);
		PFlightTypes.add(LBusiness);
		PFlightTypes.add(LEconomic1);
		PFlightTypes.add(LBusiness1);

		LBusiness.setVisible(false);
		LBusiness1.setVisible(true);
		LEconomic.setVisible(true);
		LEconomic1.setVisible(true);
	
		LDomesticFlight.setBounds(60, 40, 200, 30);
		LDivideFlights.setBounds(10,80,350,15);
		LInternationalFlight.setBounds(60, 100, 220, 30);
		LTableTitle.setBounds(350,320,250,20);

		LDomesticFlight.setVisible(false);
		LDivideFlights.setVisible(false);
		LInternationalFlight.setVisible(false);
		LTableTitle.setVisible(true);

		c.add(PFlightTypes);
		c.add(PLogin);
		c.add(PFlightDetails);

		PFlightTypes.add(LDomesticFlight);
		PFlightTypes.add(LDivideFlights);
		PFlightTypes.add(LInternationalFlight);

		pack();
		setVisible(true);

		addWindowListener(new ExitListener());

		LDomesticFlight.addMouseListener(new mouse1(this, true));
		LInternationalFlight.addMouseListener(new mouse1(this, false));

		LDomesticFlight1.addMouseListener(new mouse3(this, true));
		LInternationalFlight1.addMouseListener(new mouse3(this, false));
		LAdminPanel.addActionListener(new openadmin(this));

		LBusiness1.addMouseListener(new mouse2(this, true));
		LEconomic1.addMouseListener(new mouse2(this, false));

		BLogin.addActionListener(new button1(this));

		
	}

	public static void main(String args[])
	{
		new LoginPage();
	}
}

class openadmin implements ActionListener
{
	LoginPage type;

	public openadmin(LoginPage type)
	{
		this.type = type;
	}
	public void actionPerformed(ActionEvent e)
	{
		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
		if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE))
			try {
				URL url = new URL("http", "ec2-54-201-6-28.us-west-2.compute.amazonaws.com",80,"/FlyHighBooking/admin.php");
				desktop.browse(url.toURI());
			} catch (Exception exc) {
				System.out.println(exc);
			}
	}
//	        String filePath = "ho.pdf";
//		URL fileUrl = null;
//		try {
//			fileUrl = new URL("http", "ec2-54-201-6-28.us-west-2.compute.amazonaws.com",80,"/FlyHighBooking/ho.pdf");
//		} catch (Exception exc) {
//			System.out.println(exc);
//		}
//	        // build a component controller
//	        SwingController controller = new SwingController();
//	        controller.setIsEmbeddedComponent(true);
//	
//	        // set the viewController embeddable flag.
//	        DocumentViewController viewController =
//	                controller.getDocumentViewController();
//	
//	        JPanel viewerComponentPanel = new JPanel();
//	        viewerComponentPanel.add(viewController.getViewContainer());
//	
//	        // add copy keyboard command
//	        ComponentKeyBinding.install(controller, viewerComponentPanel);
//	
//	        // add interactive mouse link annotation support via callback
//	        controller.getDocumentViewController().setAnnotationCallback(
//	                new org.icepdf.ri.common.MyAnnotationCallback(
//	                        controller.getDocumentViewController()));
//	
//	        // build a containing JFrame for display
//	        JFrame applicationFrame = new JFrame();
//		applicationFrame.setPreferredSize(new Dimension(800,600));
////	        applicationFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//	        applicationFrame.getContentPane().add(viewerComponentPanel);
//	
//	        // Now that the GUI is all in place, we can try opening a PDF
//	        controller.openDocument("http://ec2-54-201-6-28.us-west-2.compute.amazonaws.com/FlyHighBooking/ho.pdf");
//	
//	        // hard set the page view to single page which effectively give a single
//	        // page view. This should be done after openDocument as it has code that
//	        // can change the view mode if specified by the file.
//	        controller.setPageViewMode(
//	                DocumentViewControllerImpl.ONE_PAGE_VIEW,
//	                false);
//	
//	        // show the component
//	        applicationFrame.pack();
//	        applicationFrame.setVisible(true);
//	 }
}

class button1 implements ActionListener
{
	LoginPage type;
	char[] cCheck, cPassword={'a','d','m','i','n','\0'}, cPassword2={'u','s','e','r','\0'};
	JFrame f;
	String sCheck,sCheck1="admin",sCheck2="user";

	public button1(LoginPage type)
	{
		this.type = type;
	}
	public void actionPerformed(ActionEvent e)
	{
		cCheck=type.TPPassword.getPassword();
		sCheck = type.TFUserName.getText();
		if ((sCheck1.equals(sCheck)) && check())
		{
			type.LDomesticFlight.setVisible(true);
			type.LDivideFlights.setVisible(true);
			type.LInternationalFlight.setVisible(true);
			type.LChooseClass.setVisible(true);
			type.LAdminPanel.setVisible(true);

			type.PLogin.add(type.LDomesticFlight1);
			type.PLogin.add(type.LDivideBooking);
			type.PLogin.add(type.LInternationalFlight1);
			type.PLogin.add(type.LChooseClass);
			type.PLogin.add(type.LAdminPanel);

			type.PLogin.remove(type.LUserName);
			type.PLogin.remove(type.TFUserName);
			type.PLogin.remove(type.LPassword);
			type.PLogin.remove(type.TPPassword);
			type.PLogin.remove(type.BLogin);

			type.c.repaint();
		}
		else if ((sCheck2.equals(sCheck)) && check2())
		{
			type.LDomesticFlight.setVisible(true);
			type.LDivideFlights.setVisible(true);
			type.LInternationalFlight.setVisible(true);
			type.LChooseClass.setVisible(true);

			type.PLogin.add(type.LDomesticFlight1);
			type.PLogin.add(type.LDivideBooking);
			type.PLogin.add(type.LInternationalFlight1);
			type.PLogin.add(type.LChooseClass);

			type.PLogin.remove(type.LUserName);
			type.PLogin.remove(type.TFUserName);
			type.PLogin.remove(type.LPassword);
			type.PLogin.remove(type.TPPassword);
			type.PLogin.remove(type.BLogin);

			type.c.repaint();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid username or password. Try again");
		}
	}
	public boolean check()
	{
		if (cCheck.length >= 6 || cCheck.length < 4)
			return false;
		for(int i=0;i<=4;i++)
		{
			if(cCheck[i]!=cPassword[i])
				return false;
		}
		return true;
	}
	public boolean check2()
	{
		if (cCheck.length >= 5 || cCheck.length < 3)
			return false;
		for(int i=0;i<=3;i++)
		{
			if(cCheck[i]!=cPassword2[i])
				return false;
		}
		return true;
	}
}

class mouse1 extends MouseAdapter
{
	LoginPage type;
	boolean bCheck;

	public mouse1(LoginPage type, boolean bCheck)
	{
		this.type = type;
		this.bCheck = bCheck;
	}
	public void mouseEntered(MouseEvent e)
	{
		type.LDomesticFlight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		type.LInternationalFlight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	public void mouseClicked(MouseEvent e)
	{
		if(bCheck)
			type.bCheck = true;
		else
			type.bCheck = false;
		type.LEconomic.setVisible(true);
		type.LBusiness1.setVisible(true);
		type.LEconomic1.setVisible(false);
		type.LBusiness.setVisible(false);

		type.JSP1.setVisible(false);
		type.JSP2.setVisible(false);
		type.JSP3.setVisible(false);
		type.JSP4.setVisible(false);
		if(bCheck)
			type.JSP1.setVisible(true);
		else
			type.JSP2.setVisible(true);
	}
}



class mouse3 extends MouseAdapter
{
	LoginPage type;
	boolean bCheck;

	public mouse3(LoginPage type, boolean bCheck)
	{
		this.type = type;
		this.bCheck = bCheck;
	}
	public void mouseEntered(MouseEvent e)
	{
		type.LDomesticFlight1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		type.LInternationalFlight1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	public void mouseClicked(MouseEvent e)
	{
		if (bCheck)
			new DomesticFlight(type);
		else
			new InternationalFlight(type);
	}
}


class mouse2 extends MouseAdapter
{
	LoginPage type;
	boolean bCheck;

	public mouse2(LoginPage type, boolean bCheck)
	{
		this.type = type;
		this.bCheck = bCheck;
	}
	public void mouseEntered(MouseEvent e)
	{
		type.LEconomic1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		type.LBusiness1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	public void mouseClicked(MouseEvent e)
	{
		if(type.bCheck)
		{
			if (bCheck)
			{
				type.LBusiness1.setVisible(false);
				type.LBusiness.setVisible(true);
				type.LEconomic.setVisible(false);
				type.LEconomic1.setVisible(true);
				type.JSP1.setVisible(false);
				type.JSP2.setVisible(false);
				type.JSP3.setVisible(true);
				type.JSP4.setVisible(false);
			}
			else
			{
				type.LEconomic1.setVisible(false);
				type.LBusiness.setVisible(false);
				type.LBusiness1.setVisible(true);
				type.LEconomic.setVisible(true);
				type.JSP1.setVisible(true);
				type.JSP2.setVisible(false);
				type.JSP3.setVisible(true);
				type.JSP4.setVisible(false);
			}
		}
		else
		{
			if (bCheck)
			{
				type.LBusiness1.setVisible(false);
				type.LBusiness.setVisible(true);
				type.LEconomic.setVisible(false);
				type.LEconomic1.setVisible(true);
				type.JSP1.setVisible(false);
				type.JSP2.setVisible(false);
				type.JSP3.setVisible(false);
				type.JSP4.setVisible(true);
			}
			else
			{
				type.LEconomic1.setVisible(false);
				type.LBusiness.setVisible(false);
				type.LBusiness1.setVisible(true);
				type.LEconomic.setVisible(true);
				type.JSP1.setVisible(false);
				type.JSP2.setVisible(true);
				type.JSP3.setVisible(false);
				type.JSP4.setVisible(false);
			}
		}
	}
}


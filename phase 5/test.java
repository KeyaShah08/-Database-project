import java.sql.*;
import java.io.*;
import java.util.Scanner;
import java.util.Iterator;
import java.time.*;
import java.text.*;

public class test {

	public static void main(String[] args){
		try {
			String JDBC_Driver = "oracle.jdbc.OracleDriver";
	        String DB_URL = "jdbc:oracle:thin:@acaddbprod.uta.edu:1523/pcse1p.data.uta.edu";
	        String Username = "uxs4934";
	        String Password = "NewPassword2399";        
	        Class.forName(JDBC_Driver);  
	        Connection cn = DriverManager.getConnection(DB_URL,Username,Password);   
	        
	        int i=1;      
            while(true){          
                if(i==9){
                    break;
                }else{
                    System.out.println("1. Print Tables.");
                    System.out.println("2. Get the type of art that was popular over the period of time.");
                    System.out.println("3. Get the type of art that was sold maximum in last month.");
                    System.out.println("4. Report of sales of each Art Gallery.");
                    System.out.println("5. Get the place(area by zipcode) by analyzing the maximum number of art sales by any organization or customer ");
                    System.out.println("6. Get the populairty of artist by sales of art. ");
                    System.out.println("7. Get Art Gallery revenue as whole (by art type/ entire business");
                    System.out.println("8. Get most profitable art");
                    System.out.println("9. Insert Art Gallery");
                    System.out.println("10. Delete Art Gallery");
                    System.out.println("11. Update Art Gallery");
                    
                    Scanner scan = new Scanner(System.in);
                    i = scan.nextInt();
                    System.out.println(i);
                   
                    switch(i) {                    
                    
                    case 1:
                        Display_data(cn);
                        break;
                    
                    case 2:
                    	Get_Popular_Art(cn);
                    	break;
                    
                    case 3:
                    	Get_Max_sales(cn);
                    	break;
                    
                    case 4:
                    	Get_Sales_report(cn);
                    	break;
                    	
                    case 5:
                    	Get_Sales_ByArea(cn);
                    	break;
                    
                    case 6:
                    	Get_PopularArtist(cn);
                    	break;
                    
                    case 7:
                    	Get_ArtGallery_Revenue(cn);
                    	break;
                    
                    case 8:
                    	Get_MostProfitableArt(cn);
                    	break;
                    
                    case 9:
                    	Insert_ArtGallery(cn);
                    	break;
                    	
                    case 10:
                    	Delete_ArtGallery(cn);
                    	break;
                    	
                    case 11:
                    	Update_ArtGallery(cn);
                    	break;
                    	
                    default:
                        System.out.println("Invalid Choice.");
                        break;
	        
                    }
                }
            }}
		catch(Exception e) {
            System.out.println("DB_Connect Function Exception:"+e);
		}
	}

	public static void Display_data(Connection cn) {

		try {
            Statement st = cn.createStatement();
            System.out.println("Which table do you want to print?");
            System.out.println("1. F22_S004_15_PERSON");
            System.out.println("2. F22_S004_15_ORGANIZATION");
            System.out.println("3. F22_S004_15_ART");
            System.out.println("4. F22_S004_15_ART_GALLERY");
            System.out.println("5. F22_S004_15_ARTIST");
            System.out.print("Enter Your Choice: ");
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();

            
            switch(i) {
            
                case 1:
                	ResultSet rs = st.executeQuery("select * from F22_S004_15_PERSON");
                    System.out.print("\nTable: F22_S004_15_PERSON\n\n");  
                    System.out.print("Person_Id");   gap(10,9);
                    System.out.print("First_Name");   gap(10,9);
                    System.out.print("Last_Name");   gap(10,9);
                    System.out.print("DateOfBirth");   gap(10,9);
                    System.out.print("Email");  gap(10,9);
                    System.out.print("Apartment");  gap(10,9); 
                    System.out.print("Street");   gap(10,9);
                    System.out.print("Zip");gap(10,9);
                    System.out.print("Gender  \n");  
                     
                    while(rs.next()) {
                        System.out.print(rs.getString("PERSON_ID")+" "); gap(15,15);
                        System.out.print(rs.getString("FIRST_NAME")+" ");  gap(10,10);
                        System.out.print(rs.getString("LAST_NAME")+" ");gap(10,10);
                        System.out.print(rs.getString("DOB")+" ");  
                        System.out.print(rs.getString("EMAIL")+" ");  
                        System.out.print(rs.getString("APARTMENT")+" ");
                        System.out.print(rs.getString("STREET")+" ");
                        System.out.print(rs.getString("ZIP")+" ");
                        System.out.print(rs.getString("GENDER")+" ");
                        
                      System.out.print("\n ");
                    }
                break;
                
                case 2:
                	 rs = st.executeQuery("select * from F22_S004_15_ORGANIZATION");
                     System.out.print("\nTable: F22_S004_15_ORGANIZATION\n\n");  
                
                     System.out.print("ORGANIZATION_ID");   gap(10,9);
                     System.out.print("EMAIL");   gap(10,9);
                     System.out.print("ORGANIZATION_NAME");gap(10,9);
                     System.out.print("APARTMENT");gap(10,9);
                     System.out.print("STREET");gap(10,9);
                     System.out.print("ZIP");gap(10,9);
                     System.out.print("PHONE_NUM \n");
                     
                     while(rs.next()) {
                    	 System.out.print(rs.getString("ORGANIZATION_ID")+" "); 
                         System.out.print(rs.getString("EMAIL")+" ");  
                         System.out.print(rs.getString("ORGANIZATION_NAME")+" ");
                         System.out.print(rs.getString("APARTMENT")+" ");  
                         System.out.print(rs.getString("STREET")+" ");
                         System.out.print(rs.getString("ZIP")+" ");
                         System.out.print(rs.getString("PHONE_NUM")+" ");
                         
                         System.out.print("\n ");
                     }
                     break;
                     
                case 3:
                	rs = st.executeQuery("Select * from F22_S004_15_ART");
                	System.out.print("\nTable: F22_S004_15_ART\n\n");  
                    System.out.print("ART_ID");   gap(10,9);
                    System.out.print("ART_GALLERY_ID");   gap(10,9);
                    System.out.print("ART_TYPE");   gap(10,9);
                    System.out.print("CREATED_DATE");   gap(10,9);
                    System.out.print("PRICE");  gap(10,9);
                    System.out.print("STATUS \n");  gap(10,9); 
                    
                     
                    while(rs.next()) {
                        System.out.print(rs.getString("ART_ID")+" "); gap(15,15);
                        System.out.print(rs.getString("ART_GALLERY_ID")+" ");  gap(10,10);
                        System.out.print(rs.getString("ART_TYPE")+" ");gap(10,10);
                        System.out.print(rs.getString("CREATED_DATE")+" ");  
                        System.out.print(rs.getString("PRICE")+" ");  
                        System.out.print(rs.getString("STATUS")+" ");
                        
                      System.out.print("\n ");
                    }
                break;
                
                case 4:
                	rs = st.executeQuery("Select * from F22_S004_15_ART_GALLERY");
                	System.out.print("\nTable: F22_S004_15_ART_GALLERY\n\n");  
                    System.out.print("ART_GALLERY_ID");   gap(10,9);
                    System.out.print("ART_GALLERY_NAME");   gap(10,9);
                    System.out.print("APARTMENT");   gap(10,9);
                    System.out.print("STREET");   gap(10,9);
                    System.out.print("ZIP \n");  gap(10,9);
                    
                     
                    while(rs.next()) {
                        System.out.print(rs.getString("ART_GALLERY_ID")+" "); gap(15,15);
                        System.out.print(rs.getString("ART_GALLERY_NAME")+" ");  gap(10,10);
                        System.out.print(rs.getString("APARTMENT")+" ");gap(10,10);
                        System.out.print(rs.getString("STREET")+" ");  
                        System.out.print(rs.getString("ZIP")+" "); 
                        System.out.print("\n ");
                    }
                break;
                
                case 5:
                	rs = st.executeQuery("Select * from F22_S004_15_ARTIST");
                	System.out.print("\nTable: F22_S004_15_ARTIST\n\n");  
                    System.out.print("ARTIST_ID");   gap(10,9);
                    System.out.print("PERSON_ID");   gap(10,9);
                    System.out.print("NO_OF_SALES");   gap(10,9);
                    System.out.print("EXPERTISE \n");   gap(10,9);
                     
                    while(rs.next()) {
                        System.out.print(rs.getString("ARTIST_ID")+" "); gap(15,15);
                        System.out.print(rs.getString("PERSON_ID")+" ");  gap(10,10);
                        System.out.print(rs.getString("NO_OF_SALES")+" ");gap(10,10);
                        System.out.print(rs.getString("EXPERTISE")+" ");  
                        System.out.print("\n ");
                    }
                break;
                
            }
		}
	
            catch(SQLException e) {
                System.out.println("Display_data function Exception: "+e);
            }
	
}

	public static void Get_Popular_Art(Connection cn) {
		try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT ART_TYPE, COUNT(ART_TYPE) AS NO_OF_ARTS FROM F22_S004_15_ART WHERE ART_ID IN(\r\n"
            		+ "SELECT ART_ID FROM F22_S004_15_ORG_BUYS\r\n"
            		+ "UNION\r\n"
            		+ "SELECT ART_ID FROM F22_S004_15_CUSTOMER_BUYS)\r\n"
            		+ "GROUP BY ART_TYPE\r\n"
            		+ "ORDER BY NO_OF_ARTS DESC");
            System.out.print("ART_TYPE ");
            System.out.print("NO_OF_ARTS \n "); 
            
            while(rs.next()){
                System.out.print(rs.getString("ART_TYPE")+" ");
                System.out.print(rs.getString("NO_OF_ARTS")+" ");
                System.out.println("\n");  
            }
            st.close();
            System.out.println("\n");
        }catch(SQLException e) {
            System.out.println("Get_Popular_Art Exception: "+e);
        }
	}
	
	public static void Get_Max_sales(Connection cn) {
		try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT ART_TYPE, COUNT(ART_TYPE) AS NO_OF_ARTS FROM F22_S004_15_ART WHERE ART_ID IN(\r\n"
            		+ "SELECT ART_ID FROM F22_S004_15_ORG_BUYS\r\n"
            		+ "WHERE BUY_DATE BETWEEN '01-OCT-2022' AND '31-OCT-2022'\r\n"
            		+ "UNION\r\n"
            		+ "SELECT ART_ID FROM F22_S004_15_CUSTOMER_BUYS\r\n"
            		+ "WHERE BUY_DATE BETWEEN '01-OCT-2022' AND '31-OCT-2022')\r\n"
            		+ "GROUP BY ART_TYPE\r\n"
            		+ "order by NO_OF_ARTS DESC\r\n"
            		+ "FETCH FIRST 1 ROWS ONLY");
            System.out.print("ART_TYPE ");
            System.out.print("NO_OF_ARTS \n "); 
            
            while(rs.next()){
                System.out.print(rs.getString("ART_TYPE")+" ");
                System.out.print(rs.getString("NO_OF_ARTS")+" ");
                System.out.println("\n");  
            }
            st.close();
            System.out.println("\n");
        }catch(SQLException e) {
            System.out.println("Get_Max_sales Exception: "+e);
        }
	}
	
	public static void Get_Sales_report(Connection cn) {
		try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT DISTINCT(AG.ART_GALLERY_NAME),SUM(A.PRICE) OVER (PARTITION BY AG.ART_GALLERY_NAME, A.ART_GALLERY_ID)AS REVENUE\r\n"
            		+ "    FROM F22_S004_15_ART A, F22_S004_15_ART_GALLERY AG\r\n"
            		+ "    WHERE STATUS='SOLD' AND A.ART_GALLERY_ID = AG.ART_GALLERY_ID\r\n"
            		+ "    ORDER BY REVENUE DESC\r\n"
            		+ "");
            System.out.print("ART_GALLERY_NAME ");
            System.out.print("REVENUE \n "); 
            
            while(rs.next()){
                System.out.print(rs.getString("ART_GALLERY_NAME")+" ");
                System.out.print(rs.getString("REVENUE")+" ");
                System.out.println("\n");  
            }
            st.close();
            System.out.println("\n");
        }catch(SQLException e) {
            System.out.println("Get_Sales_report Exception: "+e);
        }
	}
	
	public static void Get_Sales_ByArea(Connection cn) {
		try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT ZIP,  COUNT(ZIP) AS TOTAL_NO_OF_SALES\r\n"
            		+ "FROM F22_S004_15_PERSON\r\n"
            		+ "WHERE PERSON_ID IN(\r\n"
            		+ "      SELECT PERSON_ID  \r\n"
            		+ "      FROM F22_S004_15_CUSTOMER \r\n"
            		+ "      WHERE CUSTOMER_ID\r\n"
            		+ "      IN (\r\n"
            		+ "            SELECT CUSTOMER_ID \r\n"
            		+ "            FROM F22_S004_15_CUSTOMER_BUYS))\r\n"
            		+ "GROUP BY ZIP\r\n"
            		+ "ORDER BY TOTAL_NO_OF_SALES DESC");
            System.out.print("ZIP ");
            System.out.print("TOTAL_NO_OF_SALES \n "); 
            
            while(rs.next()){
                System.out.print(rs.getString("ZIP")+" ");
                System.out.print(rs.getString("TOTAL_NO_OF_SALES")+" ");
                System.out.println("\n");  
            }
            st.close();
            System.out.println("\n");
        }catch(SQLException e) {
            System.out.println("Get_Sales_ByArea Exception: "+e);
        }
	}
	
	public static void Get_PopularArtist(Connection cn) {
		try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT C.ARTIST_ID, COUNT(A.ART_ID) AS TOTAL_ART \r\n"
            		+ "FROM F22_S004_15_CREATES C, F22_S004_15_ART A \r\n"
            		+ "WHERE A.ART_ID \r\n"
            		+ "IN (SELECT CB.ART_ID\r\n"
            		+ "FROM F22_S004_15_CUSTOMER_BUYS CB\r\n"
            		+ "WHERE CB.ART_ID IN (SELECT ART_ID FROM F22_S004_15_ART A WHERE STATUS='SOLD')\r\n"
            		+ "UNION\r\n"
            		+ "SELECT OB.ART_ID\r\n"
            		+ "FROM F22_S004_15_ORG_BUYS OB\r\n"
            		+ "WHERE OB.ART_ID IN (SELECT ART_ID FROM F22_S004_15_ART A WHERE STATUS='SOLD')) AND A.ART_ID = C.ART_ID\r\n"
            		+ "GROUP BY C.ARTIST_ID");
            System.out.print("ARTIST_ID ");
            System.out.print("TOTAL_ART \n "); 
            
            while(rs.next()){
                System.out.print(rs.getString("ARTIST_ID")+" ");
                System.out.print(rs.getString("TOTAL_ART")+" ");
                System.out.println("\n");  
            }
            st.close();
            System.out.println("\n");
        }catch(SQLException e) {
            System.out.println("Get_PopularArtist Exception: "+e);
        }
	}
	
	public static void Get_ArtGallery_Revenue(Connection cn) {
		try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT ART_GALLERY_ID,ART_TYPE,SUM(PRICE)AS TOTAL_PRICE FROM F22_S004_15_ART\r\n"
            		+ "WHERE STATUS ='SOLD'\r\n"
            		+ "GROUP BY ROLLUP(ART_GALLERY_ID,ART_TYPE)");
            System.out.print("ART_GALLERY_ID ");
            System.out.print("ART_TYPE"); 
            System.out.print("TOTAL_PRICE \n");
            
            while(rs.next()){
                System.out.print(rs.getString("ART_GALLERY_ID")+" ");
                System.out.print(rs.getString("ART_TYPE")+" ");
                System.out.print(rs.getString("TOTAL_PRICE")+" ");
                System.out.println("\n");  
            }
            st.close();
            System.out.println("\n");
        }catch(SQLException e) {
            System.out.println("Get_ArtGallery_Revenue Exception: "+e);
        }
	}
	
	public static void Get_MostProfitableArt(Connection cn) {
		try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT ART_TYPE, SUM(PRICE) AS TOTAL_PRICE\r\n"
            		+ "FROM F22_S004_15_ART \r\n"
            		+ "WHERE STATUS = 'SOLD'\r\n"
            		+ "GROUP BY ART_TYPE\r\n"
            		+ "ORDER BY SUM(PRICE) DESC\r\n"
            		+ "FETCH FIRST 1 ROW ONLY");
            System.out.print("ART_TYPE "); 
            System.out.print("TOTAL_PRICE \n");
            
            while(rs.next()){
                System.out.print(rs.getString("ART_TYPE")+" ");
                System.out.print(rs.getString("TOTAL_PRICE")+" ");
                System.out.println("\n");  
            }
            st.close();
            System.out.println("\n");
        }catch(SQLException e) {
            System.out.println("Get_MostProfitableArt Exception: "+e);
        }
	}
	
	public static void Insert_ArtGallery(Connection cn) {
		try {
			System.out.println("\n Enter details of new art gallery");
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Art Gallery ID from 908 to 999: ");
            String aid = sc.nextLine();
            System.out.print("Enter Art Gallery Name that you want to add: ");
            String a_name = sc.nextLine();
            System.out.print("Enter Apartment ");
            String apartment = sc.nextLine();
            System.out.print("Enter Street: ");
            String street = sc.nextLine();
            System.out.print("Enter Zip: ");
            String zip = sc.nextLine();
            Statement st = cn.createStatement();           
            String sql = "INSERT INTO F22_S004_15_ART_GALLERY(ART_GALLERY_ID,ART_GALLERY_NAME,APARTMENT, STREET,ZIP) values (?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,aid);
            ps.setString(2,a_name);
            ps.setString(3,apartment);
            ps.setString(4,street);
            ps.setString(5,zip);
            ps.execute();
            st.close();
            System.out.println("\nNew Art Gallery Added Successfully.\n");
            
        }catch(SQLException e) {
            System.out.println("Insert_ArtGallery Exception: "+e);
        }

	}
	
	public static void Delete_ArtGallery(Connection cn) {
		

        try {
        
		Statement st = cn.createStatement();
		ResultSet rs = st.executeQuery("Select * from F22_S004_15_ART_GALLERY");
    	System.out.print("\nTable: F22_S004_15_ART_GALLERY\n\n");  
        System.out.print("ART_GALLERY_ID");   gap(10,9);
        System.out.print("ART_GALLERY_NAME");   gap(10,9);
        System.out.print("APARTMENT");   gap(10,9);
        System.out.print("STREET");   gap(10,9);
        System.out.print("ZIP \n");  gap(10,9);
        
         
        while(rs.next()) {
            System.out.print(rs.getString("ART_GALLERY_ID")+" "); gap(15,15);
            System.out.print(rs.getString("ART_GALLERY_NAME")+" ");  gap(10,10);
            System.out.print(rs.getString("APARTMENT")+" ");gap(10,10);
            System.out.print(rs.getString("STREET")+" ");  
            System.out.print(rs.getString("ZIP")+" "); 
            System.out.print("\n ");
        }
        
        
			System.out.println("\n Enter Art Gallery ID from the table which you want to delete");
            Scanner sc = new Scanner(System.in);
            String aid = sc.nextLine();
            st = cn.createStatement();           
            String sql = "DELETE FROM F22_S004_15_ART_GALLERY WHERE ART_GALLERY_ID = "+aid;
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.execute();
            st.close();
            System.out.println("\nArt Gallery Data Deleted Successfully.\n");
            System.out.println("\nArt Gallery Data After Deletion \n");
            rs = st.executeQuery("Select * from F22_S004_15_ART_GALLERY");
        	System.out.print("\nTable: F22_S004_15_ART_GALLERY\n\n");  
            System.out.print("ART_GALLERY_ID");   gap(10,9);
            System.out.print("ART_GALLERY_NAME");   gap(10,9);
            System.out.print("APARTMENT");   gap(10,9);
            System.out.print("STREET");   gap(10,9);
            System.out.print("ZIP \n");  gap(10,9);
        }catch(SQLException e) {
            System.out.println("Insert_ArtGallery Exception: "+e);
        }
	}

//	public static void Update_ArtGallery(Connection cn) {
//		try {
//			Statement st = cn.createStatement();
//			ResultSet rs = st.executeQuery("Select * from F22_S004_15_ART_GALLERY");
//	    	System.out.print("\nTable: F22_S004_15_ART_GALLERY\n\n");  
//	        System.out.print("ART_GALLERY_ID");   gap(10,9);
//	        System.out.print("ART_GALLERY_NAME");   gap(10,9);
//	        System.out.print("APARTMENT");   gap(10,9);
//	        System.out.print("STREET");   gap(10,9);
//	        System.out.print("ZIP \n");  gap(10,9);
//            
//	        System.out.println("\n Enter Art Gallery ID from the table which you want to update:");
//            Scanner sc = new Scanner(System.in);
//            String aid = sc.nextLine();
//            st = cn.createStatement();           
//            String sql = "UPDATE F22_S004_15_ART_GALLERY SET FROM WHERE ART_GALLERY_ID = "+aid;
//            PreparedStatement ps = cn.prepareStatement(sql);
//            ps.execute();
//            st.close();
//            System.out.println("\nArt Gallery Data Deleted Successfully.\n");
//            System.out.println("\nArt Gallery Data After Deletion \n");
//            rs = st.executeQuery("Select * from F22_S004_15_ART_GALLERY");
//        	System.out.print("\nTable: F22_S004_15_ART_GALLERY\n\n");  
//            System.out.print("ART_GALLERY_ID");   gap(10,9);
//            System.out.print("ART_GALLERY_NAME");   gap(10,9);
//            System.out.print("APARTMENT");   gap(10,9);
//            System.out.print("STREET");   gap(10,9);
//            System.out.print("ZIP \n");  gap(10,9);
//        }catch(SQLException e) {
//            System.out.println("Insert_ArtGallery Exception: "+e);
//        }
//	}
	
	public static void gap(int a,int b) {
        
        for (int i=b;i<=a;i++){
            System.out.print(" ");
        }
    }
}

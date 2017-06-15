import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class Main extends Application{

	
	static{
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
           
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
	
	Scene scene1, scene2, scene3, scene4;
	
	Connection con;
    int pom = 0;	
	public static void main(String[] args)
	{	
		Application.launch(args);
		
	}
	
	public void start(Stage window) throws Exception
	{
		try{
            
            String url = "jdbc:db2://localhost:50001/vstud";
           
            
            con = DriverManager.getConnection(url,"student","abcdef");
        

		
		// Prva scena
		Label godinaLabela1 = new Label("Godina: ");
		Label oznakaLabela1 = new Label("Oznaka:");
		TextField godinaField1 = new TextField();
		TextField oznakaField1 = new TextField();
		Button listaj = new Button("Listaj");
		Label poruka1 = new Label("");
		
		HBox godinaBox1 = new HBox(5);
		godinaBox1.getChildren().addAll(godinaLabela1, godinaField1);
		godinaBox1.setAlignment(Pos.CENTER_LEFT);
		
		
		HBox oznakaBox1 = new HBox(5);
		oznakaBox1.getChildren().addAll(oznakaLabela1, oznakaField1);
		oznakaBox1.setAlignment(Pos.CENTER_LEFT);
		
		VBox glavni1 = new VBox(10);
		glavni1.getChildren().addAll(godinaBox1, oznakaBox1, listaj, poruka1);
		
		glavni1.setPadding(new Insets(15, 15, 15, 15));
		scene1 = new Scene(glavni1, 500, 300);
		
		
		// Druga scena
		Label prvaPoruka2 = new Label("Odabrani rok ne postoji.");
		Label drugaPoruka2 = new Label("Da li zelite da ga dodate?");
		Button yes = new Button("yes");
		Button no = new Button("no");

		
		HBox dugmici2 = new HBox(80);
		dugmici2.getChildren().addAll(yes, no);
		
		VBox glavni2 = new VBox(10);
		glavni2.getChildren().addAll(prvaPoruka2, drugaPoruka2, dugmici2);
		
		glavni2.setPadding(new Insets(15, 15, 15, 15));
		scene2 = new Scene(glavni2, 500, 300);
		
		// Treca scena
		Label godinaRoka3 = new Label("Godina roka:");
		Label oznakaRoka3 = new Label("Oznaka roka:");
		Label nazivRoka3 = new Label("Naziv roka:");
		Label pocetakPrijave3 = new Label("Pocetak prijave:");
		Label krajPrijave3 = new Label("Kraj prijave:");
		Label tip3 = new Label("Tip:");
		Button potvrdi = new Button("Potvrdi");
		Button odustani = new Button("Odustani");
		TextField rezGodinaRoka3 = new TextField();
		TextField rezOznakaRoka3 = new TextField();
		TextField rezNazivRoka3 = new TextField();
		TextField rezPocetakPrijave3 = new TextField();
		TextField rezKrajPrijave3 = new TextField();
		TextField rezTip3 = new TextField();
		Label poruka = new Label("");
		
		rezPocetakPrijave3.setPromptText("yyyy-mm-dd");
		rezKrajPrijave3.setPromptText("yyyy-mm-dd");
		
		HBox prvi3 = new HBox(5);
		prvi3.getChildren().addAll(godinaRoka3, rezGodinaRoka3);
		prvi3.setAlignment(Pos.CENTER_LEFT);
		
		HBox drugi3 = new HBox(5);
		drugi3.getChildren().addAll(oznakaRoka3, rezOznakaRoka3);
		drugi3.setAlignment(Pos.CENTER_LEFT);
		
		HBox treci3 = new HBox(5);
		treci3.getChildren().addAll(nazivRoka3, rezNazivRoka3);
		treci3.setAlignment(Pos.CENTER_LEFT);
		
		HBox cetvrti3 = new HBox(5);
		cetvrti3.getChildren().addAll(pocetakPrijave3, rezPocetakPrijave3);
		cetvrti3.setAlignment(Pos.CENTER_LEFT);
		
		HBox peti3 = new HBox(5);
		peti3.getChildren().addAll(krajPrijave3, rezKrajPrijave3);
		peti3.setAlignment(Pos.CENTER_LEFT);
		
		HBox sesti3 = new HBox(5);
		sesti3.getChildren().addAll(tip3, rezTip3);
		sesti3.setAlignment(Pos.CENTER_LEFT);
		
		HBox dugmici3 = new HBox(80);
		dugmici3.getChildren().addAll(potvrdi, odustani);
		
		VBox glavni3 = new VBox(5);
		glavni3.getChildren().addAll(prvi3, drugi3, treci3, cetvrti3, peti3, sesti3, dugmici3, poruka);
		
		glavni3.setPadding(new Insets(15, 15, 15, 15));
		scene3 = new Scene(glavni3, 500, 300);
		
		//cetvrti gui
		
		Label nazivRoka4 = new Label("Naziv roka:");
		Label pocetakPrijave4 = new Label("Pocetak prijave:");
		Label krajPrijave4 = new Label("Kraj prijave:");
		Label brPrijavljenih4 = new Label("Broj prijavljenih ispita:");
		Label brPolozenih4 = new Label("Broj polozenih ispita:");
		Label brDiskvalifikovanih4 = new Label("Broj ispita na kojima su studenti diskvalifikovani:");
		Label brPonistenih4 = new Label("Broj ispita cije su ocene studenti ponistili:");
		Label prosek4 = new Label("Prosecna ocena polozenih ispita");
		
		Label rezNazivRokaLabela4 = new Label("");
		Label rezPocetakPrijaveLabela4 = new Label("");
		Label rezKrajPrijaveLabela4 = new Label("");
		Label rezBrPrijavljenihLabela4 = new Label("");
		Label rezBrPolozenihLabela4 = new Label("");
		Label rezBrDiskvalifikovanihLabela4 = new Label("");
		Label rezBrPonistenihLabela4 = new Label("");
		Label rezProsekLabela4 = new Label("");
		
		Button azuriraj = new Button("Azuriraj");
		Button obrisi = new Button("Obrisi");
		Button stampaj = new Button("Stampaj u datoteku");
		
		Label poruka3 = new Label("");
		
		HBox prvi4 = new HBox(5);
		prvi4.getChildren().addAll(nazivRoka4, rezNazivRokaLabela4);
		
		HBox drugi4 = new HBox(5);
		drugi4.getChildren().addAll(pocetakPrijave4, rezPocetakPrijaveLabela4);
		
		HBox treci4 = new HBox(5);
		treci4.getChildren().addAll(krajPrijave4, rezKrajPrijaveLabela4);
		
		HBox cetvrti4 = new HBox(5);
		cetvrti4.getChildren().addAll(brPrijavljenih4, rezBrPrijavljenihLabela4);
		
		HBox peti4 = new HBox(5);
		peti4.getChildren().addAll(brPolozenih4, rezBrPolozenihLabela4);
		
		HBox sesti4 = new HBox(5);
		sesti4.getChildren().addAll(brDiskvalifikovanih4, rezBrDiskvalifikovanihLabela4);
		
		HBox sedmi4 = new HBox(5);
		sedmi4.getChildren().addAll(brPonistenih4, rezBrPonistenihLabela4);
		
		HBox osmi4 = new HBox(5);
		osmi4.getChildren().addAll(prosek4, rezProsekLabela4);
		
		HBox dugmici4 = new HBox(5);
		dugmici4.getChildren().addAll(azuriraj, obrisi, stampaj);
		
		VBox glavni4 = new VBox(5);
		glavni4.getChildren().addAll(prvi4, drugi4, treci4, cetvrti4, peti4, sesti4, sedmi4, osmi4, dugmici4, poruka3);
		glavni4.setPadding(new Insets(15, 15, 15, 15));
		scene4 = new Scene(glavni4, 500, 300);
		
		
		
		
		//kreiranje window
		
		window.setScene(scene1);
		window.show();
		window.setTitle("Projekat");
		
		
		// Akcije

		
		no.setOnAction(e -> window.setScene(scene1));
		yes.setOnAction(e -> {
			
			
			pom = 1;
			window.setScene(scene3);
			
		});
		
		
		potvrdi.setOnAction(e -> {
            int godina = Integer.parseInt(rezGodinaRoka3.getText());
            String oznaka = rezOznakaRoka3.getText();
            String naziv = rezNazivRoka3.getText();
            String pocetak = rezPocetakPrijave3.getText();
            String kraj = rezKrajPrijave3.getText();
            String tip = rezTip3.getText();

            SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

            try
            {
                Date date1 = myFormat.parse(pocetak);
                Date date2 = myFormat.parse(kraj);
                long diff = date2.getTime() - date1.getTime();

                if(diff >= 3)
                {
                    if(pom == 1)
                    {
                      PreparedStatement upit;
                      try 
                      {
                          upit = con.prepareStatement("INSERT INTO ispitni_rok " +
                                  "values(?,?,?,?,?,?)");
                          upit.setInt(1, godina);
                          upit.setString(2, oznaka);
                          upit.setString(3, naziv);
                          upit.setDate(4, java.sql.Date.valueOf(pocetak));
                          upit.setDate(5, java.sql.Date.valueOf(kraj));
                          upit.setString(6, tip);
                          
                          try {
                          
                          int insCount = upit.executeUpdate();
                          poruka.setText("Uspesno ste uneli vrednost");
                          con.commit();
                          }
                          catch(SQLException e1)
                          {
                       	   if(e1.getErrorCode() == -913 || e1.getErrorCode() == -911)
      						{
      							poruka1.setText("Listanje nije uspesno, molim Vas pokusajte ponovo");
      							con.rollback();
      						}
                          }
                          
                          PreparedStatement AutoUpit = con.prepareStatement("insert into ispit(indeks, "+
                                  "id_predmeta, "+
                                  "godina, "+
                                  "semestar, "+
                                  "godina_roka, "+
                                  "oznaka_roka, "+
                                  "datum_prijave, "+
                                  "nacin_prijave, "+
                                  "broj_polaganja, "+
                                  "status_prijave) "+
                                  "select uk.indeks, uk.id_predmeta,uk.godina, uk.semestar,uk.godina,?, current_date, 'nasa app',10, 'p' " +
                                  "from upisan_kurs uk "+
                                  "where uk.indeks not in(select i.indeks "+
                                                       "from ispit i "+
                                                       "where i.indeks=uk.indeks and i.id_predmeta=uk.id_predmeta and "+
                                                       "ocena>5 and status_prijave='o') "+
                                  "and uk.godina=? ");
                      
                       AutoUpit.setString(1, oznaka);
                       AutoUpit.setInt(2, godina);
                      
                       try  {
                       
                       int provera = AutoUpit.executeUpdate();
                       con.commit();
                       System.out.println("Uspeo insert? " + provera);
                       }
                       catch(SQLException e1)
                       {
                    	   if(e1.getErrorCode() == -913 || e1.getErrorCode() == -911)
   						{
   							poruka1.setText("Listanje nije uspesno, molim Vas pokusajte ponovo");
   							con.rollback();
   						}
                       }
                      }
                      catch (SQLException e1)
                          {
                    	  e1.printStackTrace();
                          }
                    }
                    else
                    {
                        try
                        {
                            PreparedStatement upit = con.prepareStatement("UPDATE ispitni_rok " +
                                                                      "SET naziv = ?, " +
                                                                      "pocetak_prijavljivanja = ?, " +
                                                                      "kraj_prijavljivanja = ?, " +
                                                                      "tip = ? " +
                                                                      "WHERE godina = ? and oznaka = ?");
                            upit.setInt(5, godina);
                            upit.setString(6, oznaka);
                            upit.setString(1, naziv);
                            upit.setDate(2, java.sql.Date.valueOf(pocetak));
                            upit.setDate(3, java.sql.Date.valueOf(kraj));
                            upit.setString(4, tip);
                            
                            try{
                            
                            int insCount = upit.executeUpdate();
                            con.commit();
                            poruka.setText("Uspesno ste azurirali!");
                            }
                            catch(SQLException e1)
                            {
                            	if(e1.getErrorCode() == -913 || e1.getErrorCode() == -911)
        						{
        							poruka1.setText("Listanje nije uspesno, molim Vas pokusajte ponovo");
        							con.rollback();
        						}
                            }
                        }
                        catch (Exception e1)
                        {
                        	e1.printStackTrace();
                            
                        }

                    }
                }
                else
                {
                    poruka.setText("Greska pri unosu datuma");
                }

            }
            catch (ParseException e1)
            {
                e1.printStackTrace();
            }
});		
		stampaj.setOnAction(e -> {
			
			String naziv = rezNazivRokaLabela4.getText();
            String pocetak_prijave = rezPocetakPrijaveLabela4.getText();
            String kraj_prijave = rezKrajPrijaveLabela4.getText();
            int br_prij = Integer.parseInt(rezBrPrijavljenihLabela4.getText());
            int br_pol =  Integer.parseInt(rezBrPolozenihLabela4.getText());
            int br_disk =  Integer.parseInt(rezBrDiskvalifikovanihLabela4.getText());
            int br_pon = Integer.parseInt(rezBrPonistenihLabela4.getText());
            float prosek = Float.parseFloat(rezProsekLabela4.getText());
            
            
            ArrayList<String> niz = new ArrayList<String>();
            niz.add("Naziv: " + naziv);
            niz.add("Pocetak prijave: " + pocetak_prijave.toString());
            niz.add("Kraj prijave: " + kraj_prijave.toString());
            niz.add("Broj studenata koji su prijavljivali ispite: " + br_prij);
            niz.add("Broj studenata koji su polozili ispite: " + br_pol);
            niz.add("Broj studenata koji su diskvalifikovani sa ispita: " + br_disk);
            niz.add("Broj studenata koji su ponistili ispite: " + br_pon);
            niz.add("Prosek studenata u ovom ispitnom roku: " + prosek);
			
            
            
            FileWriter fw;
			try {
				fw = new FileWriter("ispitni_rok.txt");
				for(String pom:niz){
	                fw.write(pom);
	                fw.write("\n");
	            }
				
				poruka3.setText("Uspesno ste uneli u datoteku!");
	            fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
            
            
		});
		
		azuriraj.setOnAction(e -> window.setScene(scene3));
		
		listaj.setOnAction(e -> {
			
			rezGodinaRoka3.setEditable(false);
			rezOznakaRoka3.setEditable(false);
			
			rezGodinaRoka3.setText(godinaField1.getText());
			rezOznakaRoka3.setText(oznakaField1.getText());
			
			int godina_roka = Integer.parseInt(godinaField1.getText());
			String oznaka_roka = oznakaField1.getText();

			
			String upit = 	"with polozeni (godina, oznaka, br_polozenih, ocene) as( " +
					"select irr.godina, irr.oznaka, count(*), sum(ocena) " +
					"from ispitni_rok irr join ispit ii on irr.godina=ii.godina_roka and irr.oznaka=ii.oznaka_roka "+
					"where status_prijave='o' and ocena>5 "+
					"group by irr.godina, irr.oznaka "+
					"), "+
					"diskvalifikovani(godina, oznaka, br_diskvalifikovanih) as ( "+
					"select irrr.godina, irrr.oznaka, count(*) "+
					"from ispitni_rok irrr join ispit iii on irrr.godina=iii.godina_roka and irrr.oznaka=iii.oznaka_roka "+
					"where status_prijave='d' "+
					"group by irrr.godina, irrr.oznaka "+
					"), "+
					"ponisteni(godina, oznaka, br_ponistenih) as ( "+
					"select irrrr.godina, irrrr.oznaka, count(*) "+
					"from ispitni_rok irrrr join ispit iiii on irrrr.godina=iiii.godina_roka and irrrr.oznaka=iiii.oznaka_roka "+
					"where status_prijave='x' "+
					"group by irrrr.godina, irrrr.oznaka "+
					") "+
					"select ir.naziv, ir.pocetak_prijavljivanja, ir.kraj_prijavljivanja, count(*) br_prijavljenih, p.br_polozenih, (p.ocene/p.br_polozenih)*1.0 prosek, coalesce(d.br_diskvalifikovanih, 0) diskvalifikovani, coalesce(po.br_ponistenih, 0) ponisteni "+
					"from ispitni_rok ir join ispit "+
					"on ir.godina=ispit.godina_roka and ir.oznaka=ispit.oznaka_roka "+
					"join polozeni p on p.godina=ir.godina and p.oznaka=ir.oznaka "+
					"left join diskvalifikovani d on d.godina=ir.godina and d.oznaka=ir.oznaka "+
					"left join ponisteni po on po.oznaka=ir.oznaka and po.godina=ir.godina "+
					"where ispit.status_prijave='o' and ir.godina=? and ir.oznaka=? "+
					"group by ir.naziv, ir.pocetak_prijavljivanja, ir.kraj_prijavljivanja, p.br_polozenih, (p.ocene/p.br_polozenih)*1.0, d.br_diskvalifikovanih, po.br_ponistenih ";
			
			try {
				
				PreparedStatement brIspita = con.prepareStatement(upit);
				
				brIspita.setInt(1, godina_roka);
				brIspita.setString(2, oznaka_roka);
				
				
				try{
				
				ResultSet br_prijavljenih = brIspita.executeQuery();
				
				if(!br_prijavljenih.next())
				{
					window.setScene(scene2);
					
				}
				else
				{
					window.setScene(scene4);	
					rezNazivRokaLabela4.setText(br_prijavljenih.getString(1));
					rezPocetakPrijaveLabela4.setText(br_prijavljenih.getString(2));
					rezKrajPrijaveLabela4.setText(br_prijavljenih.getString(3));
					rezBrPrijavljenihLabela4.setText(""+br_prijavljenih.getInt(4));
					rezBrPolozenihLabela4.setText(""+br_prijavljenih.getInt(5));
					rezBrDiskvalifikovanihLabela4.setText(""+br_prijavljenih.getInt(7));
					rezBrPonistenihLabela4.setText(""+br_prijavljenih.getInt(8));
					rezProsekLabela4.setText(""+br_prijavljenih.getFloat(6));
				}
				con.commit();
				}
				catch(SQLException e1)
				{
					if(e1.getErrorCode() == -913 || e1.getErrorCode() == -911)
						{
							poruka1.setText("Listanje nije uspesno, molim Vas pokusajte ponovo");
							con.rollback();
						}
						
				}
				
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
				
		});
		
		odustani.setOnAction(e -> window.close());
		
				
		obrisi.setOnAction(e -> {
			
			
	           
            
            int godina = Integer.parseInt(godinaField1.getText());
            String oznaka = oznakaField1.getText();
           
            try {
				PreparedStatement upit = con.prepareStatement("DELETE FROM ispitni_rok " +
				                                              "WHERE godina=? and oznaka=?");
				PreparedStatement upit1 = con.prepareStatement("DELETE FROM ispit " +
                        "WHERE godina_roka=? and oznaka_roka=?");

				
				upit1.setInt(1,godina);
	            upit1.setString(2,oznaka);
	            
				upit.setInt(1,godina);
	            upit.setString(2,oznaka);
	            
	            try {
	            
	            int brObrisanihRedova = upit1.executeUpdate();
	            int brRed = upit.executeUpdate();
	           
	                           
	            poruka3.setText("Uspesno ste obrisali!");
	            con.commit();
	            }
                catch(SQLException e1)
                {
             	   if(e1.getErrorCode() == -913 || e1.getErrorCode() == -911)
					{
						poruka1.setText("Listanje nije uspesno, molim Vas pokusajte ponovo");
						con.rollback();
					}
                }
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
                
			}
            
		});
		

		}
        catch(Exception e){
            e.printStackTrace();
        }
	}
	
}

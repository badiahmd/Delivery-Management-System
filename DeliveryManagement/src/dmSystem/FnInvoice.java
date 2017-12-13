package dmSystem;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.GreekList;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.RomanList;
import com.itextpdf.text.ZapfDingbatsList;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

	public class FnInvoice {
		private DecimalFormat formatter = new DecimalFormat("#0.00");
		
		public FnInvoice(ArrayList<String> invoiceData){
			Document document = new Document();
		      try
		      {
		         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\ASUS A450LCI5 64\\Documents.pdf"));
		         document.open();
		         
		         int size = invoiceData.size();
		         
		         Font font = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
		         Paragraph paragraph1 = new Paragraph("MySoft SDN BHD Delivery", font);
		         paragraph1.setSpacingBefore(50);
		         document.add(paragraph1);
		         
		         Paragraph paragraph2 = new Paragraph("Sri Petalling,Jalan 132/4");
		         document.add(paragraph2);
		         
		         Paragraph paragraph3 = new Paragraph("Bukit Jalil, Kuala Lumpur");
		         document.add(paragraph3);
		         
		         Paragraph paragraph4 = new Paragraph("Malaysia, 57000");
		         document.add(paragraph4);
		         
		         Paragraph paragraph5 = new Paragraph("Phone: 011-569432512");
		         document.add(paragraph5);
		         
		         Paragraph paragraph6 = new Paragraph("----------------------------------------------------------------------------------------------------------------------------------");
		         paragraph6.setSpacingAfter(5);
		         document.add(paragraph6);
		         
		         Paragraph paragraph7 = new Paragraph("Invoice Date : " + invoiceData.get(size-1));
		         paragraph7.setAlignment(Element.ALIGN_RIGHT);
		         paragraph7.setSpacingAfter(15);
		         document.add(paragraph7);
		         
		         Font font2 = new Font(Font.FontFamily.HELVETICA, 17, Font.BOLD);
		         Paragraph paragraph8 = new Paragraph("Customer Information", font2);
		         paragraph8.setSpacingAfter(5);
		         document.add(paragraph8);
		        
		         PdfPTable table1 = new PdfPTable(2); //2 columns.
		         table1.setWidthPercentage(60);
		         table1.setHorizontalAlignment(Element.ALIGN_LEFT);
		         table1.setSpacingAfter(25); //Space after table
		         
		         PdfPCell cellCustomerID = new PdfPCell(new Paragraph("Customer ID"));
		         cellCustomerID.setBorder(Rectangle.NO_BORDER);
		         
		         PdfPCell cellCustomerFullName = new PdfPCell(new Paragraph("Customer Full Name"));
		         cellCustomerFullName.setBorder(Rectangle.NO_BORDER);
		         
		         PdfPCell cellCustomerPhoneNumber = new PdfPCell(new Paragraph("Customer Phone Number"));
		         cellCustomerPhoneNumber.setBorder(Rectangle.NO_BORDER);
		         
		         PdfPCell cellCustomerAddress = new PdfPCell(new Paragraph("Customer Address"));
		         cellCustomerAddress.setBorder(Rectangle.NO_BORDER);
		         
		         PdfPCell cellCustomerEmailAddress = new PdfPCell(new Paragraph("Customer Email Address"));
		         cellCustomerEmailAddress.setBorder(Rectangle.NO_BORDER);
		         
		         PdfPCell cellCustomerSubscription = new PdfPCell(new Paragraph("Customer Subscription"));
		         cellCustomerSubscription.setBorder(Rectangle.NO_BORDER);
		         
		         PdfPCell cellCustomerIDValue = new PdfPCell(new Paragraph(": " + invoiceData.get(0)));
		         cellCustomerIDValue.setBorder(Rectangle.NO_BORDER);
		         
		         PdfPCell cellCustomerFullNameValue = new PdfPCell(new Paragraph(": " + invoiceData.get(1)));
		         cellCustomerFullNameValue.setBorder(Rectangle.NO_BORDER);
		         
		         PdfPCell cellCustomerPhoneNumberValue = new PdfPCell(new Paragraph(": " + invoiceData.get(2)));
		         cellCustomerPhoneNumberValue.setBorder(Rectangle.NO_BORDER);
		         
		         PdfPCell cellCustomerAddressValue = new PdfPCell(new Paragraph(": " + invoiceData.get(3)));
		         cellCustomerAddressValue.setBorder(Rectangle.NO_BORDER);
		         
		         PdfPCell cellCustomerEmailAddressValue = new PdfPCell(new Paragraph(": " + invoiceData.get(4)));
		         cellCustomerEmailAddressValue.setBorder(Rectangle.NO_BORDER);
		         
		         PdfPCell cellCustomerSubscriptionValue = new PdfPCell(new Paragraph(": " + invoiceData.get(5)));
		         cellCustomerSubscriptionValue.setBorder(Rectangle.NO_BORDER);
		         
		         table1.addCell(cellCustomerID);
		         table1.addCell(cellCustomerIDValue);
		         table1.addCell(cellCustomerFullName);
		         table1.addCell(cellCustomerFullNameValue);
		         table1.addCell(cellCustomerPhoneNumber);
		         table1.addCell(cellCustomerPhoneNumberValue);
		         table1.addCell(cellCustomerAddress);
		         table1.addCell(cellCustomerAddressValue);
		         table1.addCell(cellCustomerEmailAddress);
		         table1.addCell(cellCustomerEmailAddressValue);
		         table1.addCell(cellCustomerSubscription);
		         table1.addCell(cellCustomerSubscriptionValue);
		         
		         document.add(table1);

		         Font font3 = new Font(Font.FontFamily.COURIER, 17, Font.BOLD);
		         Paragraph paragraph9 = new Paragraph("INVOICE", font3);
		         paragraph9.setAlignment(Element.ALIGN_CENTER);
		         paragraph9.setSpacingAfter(10);
		         document.add(paragraph9);
	         
		         PdfPTable table2 = new PdfPTable(5); //1 columns.
		         table2.setWidthPercentage(100);
		         table2.setHorizontalAlignment(Element.ALIGN_LEFT);
		         table2.setSpacingAfter(10);
		         
		         table2.addCell("Service");
		         table2.addCell("Amount Payable");
		         table2.addCell("Amount Collected");
		         table2.addCell("Last Paid On");
		         table2.addCell("Status");
		         
		         double totalAmountPayable = 0;
		         double totalAmountCollected = 0;	         
		         for (int i = 6; i < size - 1; i++) {
		        	if ((i-7)%5 == 0){
		        		totalAmountPayable += Double.parseDouble(invoiceData.get(i));
		        		table2.addCell(invoiceData.get(i));
		        	}
		        	else if ((i-8)%5 == 0){
		        		totalAmountCollected += Double.parseDouble(invoiceData.get(i));
		        		table2.addCell(invoiceData.get(i));
		        	}
		        	else {
					table2.addCell(invoiceData.get(i));
		        	}
		         }
		         
		         table2.addCell("Total");
		         table2.addCell(formatter.format(totalAmountPayable));
		         table2.addCell(formatter.format(totalAmountCollected));
		         table2.addCell("");
		         table2.addCell("");
		         
		         document.add(table2);
		         
		         double restAmount = totalAmountPayable - totalAmountCollected;
		         
		         Paragraph paragraph10 = new Paragraph("Total Amount : RM " + formatter.format(restAmount));
		         paragraph10.setSpacingAfter(40);
		         document.add(paragraph10);
		         
		         Font font4 = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
		         Paragraph paragraph11 = new Paragraph("Payment Terms", font4);
		         paragraph11.setSpacingAfter(2);
		         document.add(paragraph11);
		         
		         Font font5 = new Font(Font.FontFamily.HELVETICA, 15, Font.NORMAL);
		         Paragraph paragraph12 = new Paragraph("Please pay your invoice within 7 days of the date of invoice.", font5);
		         paragraph12.setSpacingAfter(15);
		         document.add(paragraph12);
		         
		         Paragraph paragraph13 = new Paragraph("Thank you for doing business with us.", font5);
		         document.add(paragraph13);
		         
		         document.close();
		         writer.close();
		      } catch (DocumentException e)
		      {
		         e.printStackTrace();
		      } catch (FileNotFoundException e)
		      {
		         e.printStackTrace();
		      }
		}
	}



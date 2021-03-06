import java.io.*;
import com.pdflib.pdflib;
import com.pdflib.PDFlibException;

public class Hello
{
	public static void main (String argv[])
	{
		int font;
		pdflib p = null;

		try
		{
			p = new pdflib();

			if (p.begin_document("hello.pdf", "") == -1) {
				throw new Exception("Error: " + p.get_errmsg());
			}

			p.set_info("Creator", "hello.java");
			p.set_info("Author", "Peter Brown");
			p.set_info("Title", "Hello World (Java)!");

			p.begin_page_ext(595, 842, "");
			font = p.load_font("Helvetica-Bold", "unicode", "");
			p.setfont(font, 18);
			p.set_text_pos(50,700);
			p.show("Hello World!");
			p.continue_text("(says Java)");
			p.end_page_ext("");

			p.end_document("");

		} catch (PDFlibException e) {
			System.err.print("PDFlib exception occurred in hello sample: \n");
			System.err.print("[" + e.get_errnum() + "]" + e.get_apiname() +
								": " + e.get_errmsg() + "\n");

		} catch (Exception e) {
			System.err.println(e.getMessage());
			
		} finally {
			if (p != null) {
				p.delete();
			}
		}
	}
}


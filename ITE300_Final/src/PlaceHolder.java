import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PlaceHolder extends Form {

	public static void listener() {

		id.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (id.getText().equals(holder)) {
                    id.setText("");
                    id.setForeground(Color.black);
                }
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				 if (id.getText().isEmpty()) {
	                    id.setText(holder);
	                    id.setForeground(Color.GRAY);
	                }
			}
			
		});
	}
}
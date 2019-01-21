package com.rb.chess.app.parts;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class ConsolePart {

	private Text text;

	@PostConstruct
	public void createComposite(Composite parent) {
		text = new Text(parent, SWT.READ_ONLY | SWT.MULTI);
		OutputStream out = new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				if (text.isDisposed())
					return;
				text.append(String.valueOf((char) b));
			}
		};
		final PrintStream oldOut = System.out;
		System.setOut(new PrintStream(out));
		text.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				System.setOut(oldOut);
			}
		});
	}

	@Focus
	public void setFocus() {
		text.setFocus();
	}

}

package oop.day7.account_Dependency의존관계;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

public class CreateSeqFile extends Frame implements ActionListener {
    private TextField acc, name, balance;
    private Button enter, done;
    private DataOutputStream output;
    private FileOutputStream f_stream;

    public CreateSeqFile() {
        super("Create File :-)");
        try {
            output = new DataOutputStream(new FileOutputStream("client.doc"));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e1) {
            System.err.println(e1.toString());
            System.exit(1);
        }

        // Frame 의 Pixel 사이즈 + layout
        setSize(250, 150);
        setLayout(new GridLayout(4, 2));

        add(new Label("Account"));
        acc = new TextField(20);
        // 내가 만든 text field 를 frame 에 붙이기
        add(acc);

        add(new Label("Name"));
        name = new TextField(20);
        add(name);

        add(new Label("Balance"));
        balance = new TextField(20);
        add(balance);

        // 이 버튼을 listener 에게 달아준 것
        enter = new Button("Enter");
        enter.addActionListener(this);
        add(enter);

        done = new Button("End");
        done.addActionListener(this);
        add(done);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        addRecord();
        if (e.getSource() == done) {
            try {
                output.close();
            } catch (IOException ioe) {
                System.err.println(ioe.toString());
            }
        }
        System.exit(0);

    }

    private void addRecord() {
        String accNo = "";
        double balanceData = 0.0;
        String nameData = "";
        if (!acc.getText().equals("")) {
            try {
                accNo = String.valueOf(acc.getText());
                if (accNo != null) {
                    output.writeChars(accNo);
                    output.writeUTF(name.getText());
                    output.writeUTF(balance.getText());
                    output.writeDouble(balanceData);
                }

            } catch (NumberFormatException nfe) {
                System.err.println(nfe.toString());
            } catch (IOException ioe) {
                System.err.println(ioe.toString());
            }
        }
    }

    public void closeFile() {

    }

    public void createSeqFile() {

    }

    public static void main(String[] args) {
//        new ReadSeqFile();
        new CreateSeqFile();
    }
}


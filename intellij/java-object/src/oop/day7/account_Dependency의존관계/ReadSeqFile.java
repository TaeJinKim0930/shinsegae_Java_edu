package oop.day7.account_Dependency의존관계;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ReadSeqFile extends Frame implements ActionListener {
    // TextField : 입력받는 창(label)
    private TextField acc, name, balance;
    private Button next, done;
    // 필드에 입력되는 스트림 객체(acc, name, balance)를 input 이라는 그릇에 다시 담으려고 만듬
    private DataInputStream input;

    public ReadSeqFile() {
        // Frame 에서 받아오는 super()
        super("Reading File :)");
        try {
            // 파일 생성
            input = new DataInputStream(new FileInputStream("client.doc"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e1) {
            System.err.println(e1.toString());
            System.exit(1);
        }
        // Frame 의 Pixel 사이즈 + layout
        setSize(250, 150);
        setLayout(new GridLayout(4, 2));

        acc = new TextField();
        // Read-only
        acc.setEditable(false);
        // 내가 만든 text field 를 frame 에 붙이기
        add(acc);

        add(new Label("name"));
        name = new TextField(20);
        name.setEditable(false);
        add(name);

        add(new Label("balance"));
        balance = new TextField();
        balance.setEditable(false);
        add(balance);

        next = new Button("Output");
        // this 는 자기자신을 넘겨주는거: 프레임
        next.addActionListener(this);
        add(next);


//        add(done);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 읽어오라는 출력버튼
        if (e.getSource() == next) {
            // 데이터를 한 레코드씩 읽는 메소드
            readRecord();
        } else {
            closeFile();
        }
    }

    public void readRecord() {
        String accNo;
        String balanceData;
        String nameData;

        try {
            System.out.println("hhhhh");
            accNo = input.readUTF();
            System.out.println("qqq");
            nameData = input.readUTF();
            System.out.println("eeee");
            balanceData = input.readUTF();

            System.out.println("rrrrr");

            System.out.println("dd" + accNo);
            System.out.println(nameData);
            System.out.println(balanceData);

            this.acc.setText(String.valueOf(accNo));
            this.name.setText(String.valueOf(nameData));
//            name.setText(nameData); // 같은거
            this.balance.setText(String.valueOf(balanceData));

        } catch (FileNotFoundException fne) {
            System.out.println("file not found");
            closeFile();
        } catch (EOFException eof) {
            System.out.println("end of file");
            closeFile();
        } catch (IOException ioe) {
            System.err.println(ioe.toString());
        }
    }

    public void closeFile() {
        try {
            input.close();
            System.exit(0);
        } catch (IOException e) {
            System.err.println(e.toString());
            // exception 처리되서 종료 되었다는 값은 1.
            System.exit(1);
        }
    }


    public static void main(String[] args) {
        new ReadSeqFile();
    }

}

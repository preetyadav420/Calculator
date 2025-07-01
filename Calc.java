import java.awt.*;
import java.awt.event.*;

	


class Calc extends WindowAdapter implements ActionListener 
{	double result=0;String ab;
	
	Frame f; TextField t; Button l[]=new Button[10],la,ls,lm,lc,le,ld; Panel p1,p2,p3,p;
	public Calc()
	{
		f=new Frame();
		f.setSize(300,500);
		WindowCloser wc=new WindowCloser();
		f.addWindowListener(this);
		t=new TextField();
		int i;
		for(i=0;i<10;i++)
			l[i]=new Button(""+i);
		la=new Button("+");
		ls=new Button("-");
		ld=new Button("/");
		le=new Button("=");
		lm=new Button("*");
		lc=new Button("C");
		GridLayout bl=new GridLayout(5,1);
		f.setLayout(bl);
		p=new Panel();
		GridLayout gl=new GridLayout(1,4);
		p1=new Panel();p2=new Panel();p3=new Panel();
		p.setLayout(gl);p1.setLayout(gl);p2.setLayout(gl);p3.setLayout(gl);
		f.add(t,"North");
		for(i=0;i<10;i++)
			l[i].addActionListener(this);
		ls.addActionListener(this);
		la.addActionListener(this);
		lm.addActionListener(this);
		lc.addActionListener(this);
		le.addActionListener(this);
		ld.addActionListener(this);
		p.add(l[1]);
		p.add(l[2]);
		p.add(l[3]);
		p.add(la);
	p1.add(l[4]);
	p1.add(l[5]);
	p1.add(l[6]);
	p1.add(ls);
	p2.add(l[7]);
	p2.add(l[8]);
	p2.add(l[9]);
	p2.add(lm);
	p3.add(lc);
	p3.add(l[0]);
	p3.add(ld);
	p3.add(le);
		f.add(p);
		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.setVisible(true);
	}
	
	public void WindowClosing(WindowEvent e)
	{//System.exit(1);
		Window w=e.getWindow();
		w.setVisible(false);
		w.dispose();
		System.exit(1);
	}
	
	
	String current="";boolean flag=true;
	public void actionPerformed(ActionEvent e)
	{
		String str=e.getActionCommand();
		switch(str)
		 {
            case "1":current+="1";
                     break;
            case "2":  current+="2";
                     break;
            case "3":  current+="3";
                     break;
            case "4":  current+="4";
                     break;
            case "5":  current+="5";
                     break;
            case "6":  current+="6";
                     break;
            case "7":  current+="7";
                     break;
            case "8": current+="8";
                     break;
			case "9": current+="9";
                     break;
			case "0": current+="0";
                     break;
			case "C": current="";
					  result=0.0;
					  t.setText("0");
					  flag=true;
					  break;
			case "+":operationHold('+');
					 break;
			case "-":operationHold('-');
					 break;
			case "*":operationHold('*');
					 break;
			case "/":operationHold('/');
					 break;
			case "=":operationHold('+');
					current="";
					ab=""+result;
					
					t.setText(ab);
					return;
					//break;
			
        }t.setText(current);
		}
	char op='+';
	public void operationHold(char b)
	{	if(flag)
		{	op='+';
		flag=false;}
			operation(op);
		op=b;
	}
		
	public void operation(char a)
	{	/*if(flag)
		{	result=result+Integer.parseInt(current);
			current="";
			flag=false;
		}
		else{*/
		if(a=='+')
		{	if(current=="")
				current="0";
				
			result=result+Integer.parseInt(current);
			current="";
		}
		else if(a=='-')
		{if(current=="")
				current="0";
			result=result-Integer.parseInt(current);
			current="";
		}
		else if(a=='*')
		{if(current=="")
				current="0";
			result=result*Integer.parseInt(current);
			current="";
		}
		else if(a=='/')
		{if(current=="")
				current="0";
			result=result/Integer.parseInt(current);
			current="";
		}
		//}
		t.setText(current);
	}
		
		
			
	public static void main(String args[])
	{
		Calc c=new Calc();
	}
}
		
		
		
		
	
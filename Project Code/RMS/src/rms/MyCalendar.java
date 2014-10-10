package rms;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class MyCalendar extends JButton 
{

 private DateChooser dateChooser = null;

 private String preLabel = "";

 public MyCalendar() 
 {
  this(getNowDate());
 }

 public MyCalendar(SimpleDateFormat df, String dateString) 
 {
  this();
  setToolTipText(df, dateString);
 }

 public MyCalendar(Date date) 
 {
  this("", date);
 }

 public MyCalendar(String preLabel, Date date) 
 {
  if (preLabel != null)
   this.preLabel = preLabel;
  setDate(date);
  setBorder(null);
  setCursor(new Cursor(Cursor.HAND_CURSOR));
  super.addActionListener((ActionEvent e) -> {
      if (dateChooser == null)
          dateChooser = new DateChooser();
      Point p = getLocationOnScreen();
      p.y = p.y + 30;
      dateChooser.showDateChooser(p);
  });
 }

 private static Date getNowDate() 
 {
  return Calendar.getInstance().getTime();
 }

 private static SimpleDateFormat getDefaultDateFormat() 
 {
  return new SimpleDateFormat("MMM dd, yyyy");
 }

 @Override
 public void setToolTipText(String s)
 {
    Date date;
    try {
     date = getDefaultDateFormat().parse(s);
    } catch (ParseException e) {
     date = getNowDate();
    }
    setDate(date);
 }
 
 private void setToolTipText(SimpleDateFormat df, String s) 
 {
  Date date;
  try 
  {
   date = df.parse(s);
  } 
  catch (ParseException e) 
  {
   date = getNowDate();
  }
  setDate(date);
 }
 
 

 private void setDate(Date date) 
 {
  super.setToolTipText(preLabel + getDefaultDateFormat().format(date));
 }

 public Date getDate() 
 {
  String dateString = getToolTipText().substring(preLabel.length());
  try 
  {
   return getDefaultDateFormat().parse(dateString);
  } 
  catch (ParseException e) 
  {
   return getNowDate();
  }

 }

 @Override
 public void addActionListener(ActionListener listener) 
 {
     
 }

 private class DateChooser extends JPanel implements ActionListener,
   ChangeListener 
 {
  int startYear = 1980; //min year

  int lastYear = 2050;  //max year

  int width = 300;

  int height = 300;

  Color backGroundColor = Color.gray; //background color
  Color palletTableColor = Color.white;
  Color todayBackColor = Color.blue;
  Color weekFontColor = Color.black;
  Color dateFontColor = Color.black;
  Color weekendFontColor = Color.black;

  Color controlLineColor = Color.blue;
  Color controlTextColor = Color.white;
  Color rbFontColor = Color.white;
  Color rbBorderColor = Color.blue;
  Color rbButtonColor = Color.blue;
  Color rbBtFontColor = Color.red;

  JDialog dialog;

  JSpinner yearSpin;

  JSpinner monthSpin;

  JButton[][] daysButton = new JButton[6][7];

  DateChooser() 
  {
   setLayout(new BorderLayout());
   setBorder(new LineBorder(backGroundColor, 2));
   setBackground(backGroundColor);

   JPanel topYearAndMonth = createYearAndMonthPanel();
   add(topYearAndMonth, BorderLayout.NORTH);
   JPanel centerWeekAndDay = createWeekAndDayPanel();
   add(centerWeekAndDay, BorderLayout.CENTER);
  }

  private JPanel createYearAndMonthPanel() 
  {
   Calendar c = getCalendar();
   int currentYear = c.get(Calendar.YEAR);
   int currentMonth = c.get(Calendar.MONTH) + 1;

   JPanel result = new JPanel();
   result.setLayout(new FlowLayout());
   result.setBackground(controlLineColor);

   yearSpin = new JSpinner(new SpinnerNumberModel(currentYear, startYear, lastYear, 1));
   yearSpin.setPreferredSize(new Dimension(68, 30));
   yearSpin.setName("Year");
   yearSpin.setEditor(new JSpinner.NumberEditor(yearSpin, "####"));
   yearSpin.addChangeListener(this);
   result.add(yearSpin);

   JLabel yearLabel = new JLabel("Year");
   yearLabel.setForeground(controlTextColor);
   result.add(yearLabel);

   monthSpin = new JSpinner(new SpinnerNumberModel(currentMonth, 1, 12, 1));
   monthSpin.setPreferredSize(new Dimension(45, 30));
   monthSpin.setName("Month");
   monthSpin.addChangeListener(this);
   result.add(monthSpin);

   JLabel monthLabel = new JLabel("Month");
   monthLabel.setForeground(controlTextColor);
   result.add(monthLabel);

   return result;
  }

  private JPanel createWeekAndDayPanel() 
  {
   String colname[] = { "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa" };
   JPanel result = new JPanel();
   
   result.setFont(new Font("Comic Sans MS", Font.PLAIN, 8));
   result.setLayout(new GridLayout(7, 7));
   result.setBackground(Color.white);
   JLabel cell;

   for (int i = 0; i < 7; i++) {
    cell = new JLabel(colname[i]);
    cell.setHorizontalAlignment(JLabel.CENTER);
    if (i == 0 || i == 6)
     cell.setForeground(weekendFontColor);
    else
     cell.setForeground(weekFontColor);
    result.add(cell);
   }

   int actionCommandId = 0;
   for (int i = 0; i < 6; i++)
    for (int j = 0; j < 7; j++) {
     JButton numberButton = new JButton();
     numberButton.setBorder(null);
     numberButton.setHorizontalAlignment(SwingConstants.CENTER);
     numberButton.setActionCommand(String.valueOf(actionCommandId));
     numberButton.addActionListener(this);
     numberButton.setBackground(palletTableColor);
     numberButton.setForeground(dateFontColor);
     if (j == 0 || j == 6)
      numberButton.setForeground(weekendFontColor);
     else
      numberButton.setForeground(dateFontColor);
     daysButton[i][j] = numberButton;
     result.add(numberButton);
     actionCommandId++;
    }

   return result;
  }

  private JDialog createDialog(JDialog owner) 
  {
   JDialog result = new JDialog(owner, "MyCalendar", true);
   result.setResizable(false);
   result.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
   result.getContentPane().add(this, BorderLayout.CENTER);
   result.pack();
   result.setSize(width, height);
   return result;
  }

  void showDateChooser(Point position) 
  {
   JDialog owner = (JDialog) SwingUtilities.getWindowAncestor(MyCalendar.this);
   if (dialog == null || dialog.getOwner() != owner)
    dialog = createDialog(owner);
   dialog.setLocation(getAppropriateLocation(owner, position));
   updateWeekAndDay();
   dialog.show();
  }

  Point getAppropriateLocation(JDialog owner, Point position) 
  {
   Point result = new Point(position);
   Point p = owner.getLocation();
   int offsetX = (position.x + width) - (p.x + owner.getWidth());
   int offsetY = (position.y + height) - (p.y + owner.getHeight());

   if (offsetX > 0) {
    result.x -= offsetX;
   }

   if (offsetY > 0) {
    result.y -= offsetY;
   }

   return result;

  }

  private Calendar getCalendar() 
  {
   Calendar result = Calendar.getInstance();
   result.setTime(getDate());
   return result;
  }

  private int getSelectedYear() 
  {
   return (Integer) yearSpin.getValue();
  }

  private int getSelectedMonth() 
  {
   return (Integer) monthSpin.getValue();
  }

  private void updateDayColor(boolean isOldDay) 
  {
   Calendar c = getCalendar();
   int day = c.get(Calendar.DAY_OF_MONTH);
   c.set(Calendar.DAY_OF_MONTH, 1);
   int actionCommandId = day - 2 + c.get(Calendar.DAY_OF_WEEK);
   int i = actionCommandId / 7;
   int j = actionCommandId % 7;
   if (isOldDay)
    daysButton[i][j].setForeground(dateFontColor);
   else
    daysButton[i][j].setForeground(todayBackColor);
  }

  private void updateWeekAndDay() 
  {
   Calendar c = getCalendar();
   c.set(Calendar.DAY_OF_MONTH, 1);
   int maxDayNo = c.getActualMaximum(Calendar.DAY_OF_MONTH);
   int dayNo = 2 - c.get(Calendar.DAY_OF_WEEK);
   for (int i = 0; i < 6; i++) 
   {
    for (int j = 0; j < 7; j++) 
    {
     String s = "";
     if (dayNo >= 1 && dayNo <= maxDayNo)
      s = String.valueOf(dayNo);
     daysButton[i][j].setText(s);
     dayNo++;
    }
   }
   updateDayColor(false);
  }

  @Override
  public void stateChanged(ChangeEvent e) 
  {
   JSpinner source = (JSpinner) e.getSource();
   Calendar c = getCalendar();

   updateDayColor(true);

   if (source.getName().equals("Year"))
    c.set(Calendar.YEAR, getSelectedYear());
   else
    // (source.getName().equals("Month"))
    c.set(Calendar.MONTH, getSelectedMonth() - 1);
   setDate(c.getTime());
   updateWeekAndDay();
  }

  @Override
  public void actionPerformed(ActionEvent e) 
  {
   JButton source = (JButton) e.getSource();
   if (source.getText().length() == 0)
    return;
   updateDayColor(true);
   source.setForeground(todayBackColor);
   int newDay = Integer.parseInt(source.getText());
   Calendar c = getCalendar();
   c.set(Calendar.DAY_OF_MONTH, newDay);
   setDate(c.getTime());
  }

 }//end class DateChooser
 public static void main(String args[])
 {
  MyCalendar d=new MyCalendar();
 }

}
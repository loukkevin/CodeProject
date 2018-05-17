/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextbus;

/**
 *
 * @author Kevin
 */
public class Stop {
    
    private String Text;
    private String Value;
    public String getText ()
    {
        return Text;
    }

    public void setText (String Text)
    {
        this.Text = Text;
    }

    public String getValue ()
    {
        return Value;
    }

    public void setValue (String Value)
    {
        this.Value = Value;
    }

    @Override
    public String toString()
    {
        return "Stop -> [Text = "+Text+", Value = "+Value+"]";
    }
}

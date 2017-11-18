package org.firstinspires.ftc.teamcode;

/**
 * Created by NoahR on 9/16/17.
 * Class to represent a Vector in 2D space.
 */

public class Vector2D {

    // Unit vectors
    static final Vector2D UNIT_VECTOR_IHAT = new Vector2D(1, 0);
    static final Vector2D UNIT_VECTOR_JHAT = new Vector2D(0, 1);

    private double m_nXComponent;
    private double m_nYComponent;

    public Vector2D( Vector2D vecVector ) { 
        this.m_nXComponent = vecVector.GetXComponent();
        this.m_nYComponent = vecVector.GetYComponent();
    }

    public Vector2D( double nXComponent, double nYComponent ) 
    {
        m_nXComponent = nXComponent;
        m_nYComponent = nYComponent;
    }

    public double GetXComponent() { return m_nXComponent; }
    public double GetYComponent() { return m_nYComponent; }

    public double GetMagnitude()
    {
        return Math.sqrt( ( Math.pow(m_nXComponent, 2 ) ) + ( Math.pow(m_nYComponent, 2 ) ) );
    }
    public double GetDirection()
    {
        return Math.toDegrees( Math.atan2( m_nYComponent, m_nXComponent ) );
    }

    public void Set( Vector2D vNewVector ) { this.SetComponents( vNewVector.GetXComponent(), vNewVector.GetYComponent() ); }
    public void SetPolar( double nMagnitude, double nDirection )
    {
        m_nXComponent = nMagnitude * Math.cos( Math.toRadians(nDirection) );
        m_nYComponent = nMagnitude * Math.sin( Math.toRadians(nDirection) );
    }
    public void SetComponents( double nXComponent, double nYComponent )
    {
        m_nXComponent = nXComponent;
        m_nYComponent = nYComponent;
    }

    public void Add( Vector2D vDelta ) { this.AddComponents( vDelta.GetXComponent(), vDelta.GetYComponent() ); }
    public void AddPolar( double nMagnitude, double nDirection )
    {
        m_nXComponent += nMagnitude * Math.cos( Math.toRadians(nDirection) );
        m_nYComponent += nMagnitude * Math.sin( Math.toRadians(nDirection) );
    }
    public void AddComponents( double nXComponent, double nYComponent )
    {
        m_nXComponent += nXComponent;
        m_nYComponent += nYComponent;
    }

    public void Multiply( Vector2D vVector ) { this.MultiplyComponents( vVector.GetXComponent(), vVector.GetYComponent() ); }
    public void MultiplyPolar( double nMagnitude, double nDirection )
    {
        m_nXComponent *= nMagnitude * Math.cos( Math.toRadians(nDirection) );
        m_nYComponent *= nMagnitude * Math.sin( Math.toRadians(nDirection) );
    }
    public void MultiplyComponents( double nXComponent, double nYComponent )
    {
        m_nXComponent *= nXComponent;
        m_nYComponent *= nYComponent;
    }

    public double DotProduct( Vector2D vVector )
    {
        return ( m_nXComponent * vVector.GetXComponent() ) + ( m_nYComponent * vVector.GetYComponent() );
    }
    
    public void MultiplyScalar( double nFactor )
    {
        m_nXComponent *= nFactor;
        m_nYComponent *= nFactor;
    }

    public void Rotate( double nDegrees )
    {
        this.SetPolar(this.GetMagnitude(), this.GetDirection() + nDegrees);
    }


    public void FlipVertically()
    {
        m_nYComponent *= -1;
    }

    public void FlipHorizontally()
    {
        m_nXComponent *= -1;
    }
}

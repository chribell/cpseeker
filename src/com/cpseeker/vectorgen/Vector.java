package com.cpseeker.vectorgen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.cpseeker.CodeFragment;

/**
 * It's the base for everything. Each {@link CodeFragment}
 * has one. It describes a given fragment of source code
 * in a simpler form, so it can be much easier and more quickly
 * compared, hashed, iterated, etc.
 * 
 * @author chribell
 *
 */
public class Vector 
{
	/**
	 * The vector itself. A vector of n-dimension
	 * is simple a list of double values.
	 */
	private List<Double> vector_;
	/**
	 * The vector's {@link CodeFragment} reference.
	 */
	private CodeFragment codeFragment_;
	/**
	 * Public constructor.
	 * @param dimension
	 *			The vector's dimension (size of list). 			 
	 */
	public Vector(int dimension)
	{
		vector_ = new ArrayList<Double>(Collections.<Double>nCopies(dimension, 0.0));
	}
	/**
	 * Sets the vector's {@link CodeFragment} to a specific.
	 * @param codeFragment
	 * 			The {@link CodeFragment} to be set.
	 */
	public void setCodeFragment(CodeFragment codeFragment)
	{
		codeFragment_ = codeFragment;
	}
	/**
	 * Returns the vector's {@link CodeFragment}.
	 * @return
	 * 			The vector's {@link CodeFragment}.
	 */
	public CodeFragment getCodeFragment()
	{
		return codeFragment_;
	}
	/**
	 * Returns the n-dimension list which contains all the vector's points.
	 * @return
	 * 			The list which describes the vector. 
	 */
	public List<Double> getVector()
	{
		return vector_;
	}
	/**
	 * Returns the vector's dimension.
	 * @return
	 * 			The vector's dimension.
	 */
	public int getDimension()
	{
		return vector_.size();
	}
	/**
	 * Returns the vector's value at a specific point/index. 
	 * @param point
	 * 			The index of the list to be searched.
	 * @return
	 * 			The value to be found in the given index.
	 */
	public double getValueAt(int point)
	{
		return vector_.get(point);
	}
	/**
	 * Sets a value to a specific vector's point/index. 
	 * @param value
	 * 			The value to be set.
	 * @param point
	 * 			The point to be updated.
	 */
	public void setValueAt(double value, int point)
	{
		vector_.set(point, value);
	}
	/**
	 * Increases the value at the given point/index by 1.
	 * @param point
	 *			The index of the list which value is going to be increased by 1. 
	 */
	public void increaseElementAt(int point)
	{
		double value = vector_.get(point);
		value++;
		vector_.set(point, value);		
	}
	/**
	 * Merges two vectors into one.
	 * Essentially, it's a vectors' addition, element by element.
	 * @param other
	 * 			The vector to be added.
	 */
	public void merge(Vector other)
	{
		if(vector_.size() != other.getVector().size()) return;
		Double[] array = new Double[vector_.size()];
		vector_.toArray(array);
		Double[] array1 = new Double[other.getVector().size()];
		other.getVector().toArray(array1);
		for(int i = 0; i < array.length; i++)
		{
			array[i] += array1[i];
		}
		vector_ = Arrays.asList(array);
	}
	/**
	 * Calculates the scalar product of this vector with the
	 * other vector. Or the vectors' inner product (euclidean). 
	 * 
	 * @param other
	 *          The other vector, should have the same number of points.
	 * @return
     * 			The scalar product of this vector with the other vector.
	 */
	public int scalarProduct(Vector other) 
	{
		int sum = 0;
		for(int i = 0; i < getDimension(); i++) 
		{
			sum += vector_.get(i) * other.getValueAt(i);		
		}
		return sum;
	}
	/**
	 * Returns the sum of all the vector's elements.
	 * This value represents the "code size" of the vector's code fragment.
	 * @return
	 * 			The sum of all the vector's elements.
	 */
	public int getCodeSize()
	{
		int sum = 0;
		for(Double value : vector_)
		{
			sum += value;
		}
		return sum;
	}
	/**
	 * Checks if the vector and a query vector differ.
	 * @param other
	 * 		The query vector.
	 * @param threshold
	 * 		The minimum number of different elements.
	 * @return
	 * 		True if the vectors differ, otherwise false. 
	 */
	public boolean differs(Vector other, int threshold)
	{
		int count = 0;
		for(int i = 0; i < vector_.size(); i++)
		{
			double a = vector_.get(i);
			double b = other.getValueAt(i);
			if(!((a == 0.0 && b == 0 )|| (a > 0 && b > 0)))
			{
				count++;
			}
			if(count > threshold) return true;
		}
		return false;
	}
	/**
	 * Returns the vector as a string. For example, for a vector v of n-dimension,
	 * the string will have this form <x<sub>0</sub>,x<sub>1</sub>,....,x<sub>n-1</sub>>
	 *
	 * @return
	 * 			The vector as string.
	 */
	@Override
	public String toString()
	{
		String s = "<";
		for(Double value : vector_)
		{
			s += value.toString() + ","; 
		}
		if(s.length() > 1) s = s.substring(0,s.length()-1);
		s += ">";
		return s;
	}
}

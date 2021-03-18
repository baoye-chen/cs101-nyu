import java.util.ArrayList;

public class Stack extends ArrayList{
	
	private ArrayList<Integer> m_array;
	private int m_current;
	
	public Stack()
	{
		m_current = 0;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		m_array = temp;
	}

	public int Size()
	{
		return m_current;
	}

	public int Peek()
	{
		return this.m_array.get(m_current - 1);
	}
	
	public int Pop()
	{
		int out = m_array.get(m_current - 1);
		m_array.remove(m_current-1);
		m_current--;
		return out;
	}

	public void Push(int v)
	{
		this.m_array.add(v);
		m_current++;
 	}
	
 	public String toString()
 	{
 		return "The stack is: " + this.m_array.toString();
 	}

 	public boolean equals(Stack m)
 	{
 		
 		if(m instanceof Stack)
 		{
 			return m.m_array.equals(this.m_array);
 		}
 		else
 		{
 			return false;
 		}
 	}
 	
	public boolean empty()
	{
		return m_current == 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack myStack = new Stack();
		for(int i = 0; i < 3; i++)
		{
			myStack.Push(i);
			System.out.println(i + " is pushed in");
			System.out.println("Now the top element is: " + myStack.Peek());
		}
		
		Stack myStack2 = new Stack();
		for(int i = 0; i < 3; i++)
		{
			myStack2.Push(i);
		}
		System.out.println("Stack 1: "+myStack.toString());
		System.out.println("Stack 2: "+myStack2.toString());
		System.out.println("Whether Stack 1 and Stack 2 are equal: " + myStack.equals(myStack2));
		
		System.out.println("The size of stack 1 is: " + myStack.Size());
		System.out.println("Whether stack 1 is empty: " + myStack.empty());
		System.out.println(+myStack.Pop() + " is popped from stack 1!");
		System.out.println("Compare again whether Stack 1 and Stack 2 are equal: " + myStack.equals(myStack2));
		System.out.println("Stack 1: "+myStack.toString());
		
	}

}

#include <iostream>

template <typename T>
struct Node
{
	T data;
	Node<T> *next;
};


template <typename T>
class LinkedList
{
public:
	LinkedList()
	{
	}

	~LinkedList()
	{
		Node<T>* cur{head};
		Node<T>* prev{nullptr};

		while (cur != nullptr)
		{
			prev = cur;
			cur = cur->next;
			delete prev;
		}
		head = nullptr;
	}
	void insert(T value);
	void print();

private:
	Node<T>* head{nullptr};

	Node<T>* create_node(T value, Node<T>* ptr);

};

template <typename T>
Node<T>* LinkedList<T>::create_node(T value, Node<T>* ptr)
{
	Node<T>* new_node = new Node<T>;
	new_node->data = value;
	new_node->next = ptr;
	return new_node;
}


template <typename T>
void LinkedList<T>::insert(T value)
{
	Node<T>* new_node = create_node(value, nullptr);

	if (head == nullptr)
	{
		head = new_node;
		return;
	}

	Node<T>* temp{head};

	while (temp->next != nullptr)
		temp = temp->next;

	temp->next = new_node;

}


template <typename T>
void LinkedList<T>::print()
{
	Node<T>* temp{head};

	while (temp != nullptr)
	{
		std::cout << temp->data << " ";
		temp = temp->next;
	}
}


int main()
{
	LinkedList<int> list{};
	
	int option{};



	std::cout << "Operations\n\n";
	std::cout << "0: exit.\n";
	std::cout << "1: Insert an element.\n";
	std::cout << "2: Print the list.\n";
	std::cout << "3: Delete the list.\n\n";
	
	int pos, val;
	while (true) 
	{
		std::cout << "\nEnter the operation: ";
		std::cin >> option;
		switch (option)
		{
			case 0:
				return 0;		
			case 1:
				std::cout << "Enter the value of element: "; 
				std::cin >> val;
				list.insert(val);
				break;
			case 2: 
				list.print();
				std::cout << "\n";
				break;
			case 3: 
				// delete_list(list); 
				break;
			default: 
				std::cerr << "Error: Invalid operation.\n";
		}
	
	}
	return 0;
}


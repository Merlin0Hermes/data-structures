#include <iostream>

typedef struct Node
{
	int data;
	Node *next;
};


Node* create_node(int value, Node *ptr)
{
	Node *new_node = new Node;
	new_node->data = value;
	new_node->next = ptr;
	return new_node;
}


void insert_beginning(Node *&head, int value)
{
	Node *temp = create_node(value, head);

	head = temp;
}


void insert(Node*& head, int pos, int value)
{	
	
	if (head == nullptr || pos == 1)
	{
		insert_beginning(head, value);
		return;
	}

	Node *new_node = create_node(value, nullptr);

	Node *temp = head;
	for (int i = 1; temp != nullptr && i < pos - 1; i++)
		temp = temp->next;

	if (temp == nullptr)
	{
		std::cerr << "Invalid index.\n";
		delete new_node;
		return;
	}

	new_node->next = temp->next;
	temp->next = new_node;

}


void insert_end(Node *&head, int value)
{
	// create a new node and set its data and next fields
	Node *new_node = create_node(value, nullptr);

	// special case if list is empty
	if (head == nullptr)
	{
		head = new_node;
		return;
	}

	Node *temp = head;
	while (temp->next != NULL)
	{
		temp = temp->next;
	}
	temp->next = new_node;
}


void delete_list(Node *&head)
{
	Node *cur = head;
	Node *prev = nullptr;
	
	while (cur != nullptr) 
	{
		prev = cur;
		cur = cur->next;
		delete prev;
	}

	head = nullptr;
}


void print_list(Node *head)
{
	Node *temp = head;

	while (temp != nullptr)
	{
		std::cout << temp->data << " ";
		temp = temp->next;
	}
	std::cout << std::endl;
}


int main()
{
	Node *list = nullptr;
	
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
				delete_list(list);
				return 0;		
			case 1:
				std::cout << "Enter the position and value of element: "; 
				std::cin >> pos >> val;
				insert(list, pos, val);
				break;
			case 2: 
				print_list(list); 
				break;
			case 3: 
				delete_list(list); 
				break;
			default: 
				std::cerr << "Error: Invalid operation.\n";
		}
	
	}

	delete_list(list);
	return 0;
}


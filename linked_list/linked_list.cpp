#include <iostream>

typedef struct Node
{
	int data;
	Node *next;
};


void insert_end(Node*& head, int value)
{
	Node *new_node = new Node;
	new_node->next = nullptr;
	new_node->data = value;

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


void delete_list(Node*& head)
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

	for (Node *temp = list; temp != nullptr; temp = temp->next)
	{
		std::cout << temp->data << " ";
	}

	delete_list(list);
	return 0;
}


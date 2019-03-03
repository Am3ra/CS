#pragma once

typedef struct binary_tree_node treeNode;

treeNode *CreateTreeNode(treeNode *father,int value);

treeNode *SearchTree(treeNode *node, int value);
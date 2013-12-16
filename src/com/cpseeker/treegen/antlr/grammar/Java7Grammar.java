package com.cpseeker.treegen.antlr.grammar;

public class Java7Grammar implements IGrammar 
{
	private final String name_ = "Java7";
	private final String firstRule_ = "compilationUnit";
	private final String[] extensions_ = {"java"};
	private final String[] relevantNodes_ = {"compilationUnit","packageDeclaration","importDeclaration",
			"typeDeclaration","modifier","classOrInterfaceModifier","variableModifier","classDeclaration",
			"typeParameters","typeParameter","typeBound","enumDeclaration","enumConstants","enumConstant",
			"enumBodyDeclarations","interfaceDeclaration","typeList","classBody","interfaceBody","classBodyDeclaration",
			"memberDeclaration","methodDeclaration","genericMethodDeclaration","constructorDeclaration",
			"genericConstructorDeclaration","fieldDeclaration","interfaceBodyDeclaration","interfaceMemberDeclaration",
			"constDeclaration","constantDeclarator","interfaceMethodDeclaration","genericInterfaceMethodDeclaration",
			"variableDeclarators","variableDeclarator","variableDeclaratorId","variableInitializer","arrayInitializer",
			"packageOrTypeName","enumConstantName","typeName","type","typeArguments",
			"typeArgument","qualifiedNameList","formalParameters","formalParameterList","formalParameter",
			"lastFormalParameter","methodBody","constructorBody","qualifiedName","annotation",
			"annotationName","elementValuePairs","elementValuePair","elementValue","elementValueArrayInitializer",
			"annotationTypeDeclaration","annotationTypeBody","annotationTypeElementDeclaration","annotationTypeElementRest",
			"annotationMethodOrConstantRest","annotationMethodRest","annotationConstantRest","defaultValue","block",
			"blockStatement","localVariableDeclarationStatement","localVariableDeclaration","statement","ifStatement",
			"whileStatement","switchStatement","synchronizedStatement","throwStatement","catches","catchClause",
			"catchType","finallyBlock","resourceSpecification","resources","resource","switchBlockStatementGroup",
			"switchLabel","forControl","forInit","enhancedForControl","forUpdate","parExpression","expressionList",
			"statementExpression","constantExpression","expression","primary","creator","createdName","innerCreator",
			"arrayCreatorRest","classCreatorRest","explicitGenericInvocation","nonWildcardTypeArguments",
			"typeArgumentsOrDiamond","nonWildcardTypeArgumentsOrDiamond","superSuffix",	"explicitGenericInvocationSuffix",
			"arguments"};
	private final String[] mergeableNodes_ = {"memberDeclaration","statement","localVariableDeclaration"};
	private final String[] significantNodes_ = {"typeDeclaration","memberDeclaration",//"block",
			"localVariableDeclaration","statement","expression"};
	@Override
	public String getName() 
	{
		return name_;
	}

	@Override
	public String getFirstRule() 
	{
		return firstRule_;
	}

	@Override
	public String[] getExtensions() 
	{
		return extensions_;
	}

	@Override
	public String[] getRelevantNodes() 
	{
		return relevantNodes_;
	}
	
	@Override
	public String[] getMergeableNodes() 
	{
		return mergeableNodes_;
	}

	@Override
	public String[] getSignificantNodes() 
	{
		return significantNodes_;
	}

}

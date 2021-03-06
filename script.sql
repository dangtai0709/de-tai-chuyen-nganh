USE [master]
GO
/****** Object:  Database [sanbong]    Script Date: 11/7/2018 9:38:35 AM ******/
CREATE DATABASE [sanbong]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'sanbong', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\sanbong.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'sanbong_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\sanbong_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [sanbong] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [sanbong].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [sanbong] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [sanbong] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [sanbong] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [sanbong] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [sanbong] SET ARITHABORT OFF 
GO
ALTER DATABASE [sanbong] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [sanbong] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [sanbong] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [sanbong] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [sanbong] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [sanbong] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [sanbong] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [sanbong] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [sanbong] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [sanbong] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [sanbong] SET  DISABLE_BROKER 
GO
ALTER DATABASE [sanbong] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [sanbong] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [sanbong] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [sanbong] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [sanbong] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [sanbong] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [sanbong] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [sanbong] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [sanbong] SET  MULTI_USER 
GO
ALTER DATABASE [sanbong] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [sanbong] SET DB_CHAINING OFF 
GO
ALTER DATABASE [sanbong] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [sanbong] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [sanbong]
GO
/****** Object:  Table [dbo].[datsan]    Script Date: 11/7/2018 9:38:36 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[datsan](
	[mataikhoan] [nvarchar](50) NOT NULL,
	[masanbong] [nvarchar](50) NOT NULL,
	[tennguoidat] [nvarchar](50) NULL,
	[ngay] [nvarchar](50) NOT NULL,
	[batdau] [nvarchar](50) NOT NULL,
	[lienhe] [nvarchar](50) NULL,
	[ghichu] [nvarchar](50) NULL,
 CONSTRAINT [PK_datsan] PRIMARY KEY CLUSTERED 
(
	[mataikhoan] ASC,
	[masanbong] ASC,
	[ngay] ASC,
	[batdau] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[doibong]    Script Date: 11/7/2018 9:38:36 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[doibong](
	[madoibong] [nvarchar](50) NOT NULL,
	[mataikhoan] [nvarchar](50) NOT NULL,
	[tendoi] [nvarchar](50) NULL,
	[trinhdo] [nvarchar](50) NULL,
	[anh] [nvarchar](100) NULL,
	[timdoi] [nvarchar](50) NULL,
	[cosan] [nvarchar](50) NULL,
	[thoiogianthuongda] [nvarchar](100) NULL,
	[gioithieu] [nvarchar](300) NULL,
	[khuvuc] [nvarchar](50) NULL,
 CONSTRAINT [PK_doibong] PRIMARY KEY CLUSTERED 
(
	[madoibong] ASC,
	[mataikhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[sanbong]    Script Date: 11/7/2018 9:38:36 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sanbong](
	[masanbong] [nvarchar](50) NOT NULL,
	[mataikhoan] [nvarchar](50) NOT NULL,
	[loaisan] [nvarchar](50) NULL,
	[tensan] [nvarchar](50) NULL,
	[anh] [nvarchar](100) NULL,
	[thongtin] [nvarchar](200) NULL,
	[khuvuc] [nvarchar](50) NULL,
	[gia1] [nvarchar](50) NULL,
	[gia2] [nvarchar](50) NULL,
	[gia3] [nvarchar](50) NULL,
	[gia4] [nvarchar](50) NULL,
	[gia5] [nvarchar](50) NULL,
	[sosan] [nvarchar](50) NULL,
 CONSTRAINT [PK_sanbong] PRIMARY KEY CLUSTERED 
(
	[masanbong] ASC,
	[mataikhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[taikhoan]    Script Date: 11/7/2018 9:38:36 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[taikhoan](
	[mataikhoan] [nvarchar](50) NOT NULL,
	[ten] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
	[sodienthoai] [nvarchar](50) NOT NULL,
	[anh] [nvarchar](200) NULL,
	[matkhau] [nvarchar](50) NULL,
 CONSTRAINT [PK_taikhoan] PRIMARY KEY CLUSTERED 
(
	[mataikhoan] ASC,
	[sodienthoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[thongbao]    Script Date: 11/7/2018 9:38:36 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[thongbao](
	[mataikhoan] [nvarchar](50) NOT NULL,
	[mathongbao] [int] IDENTITY(1,1) NOT NULL,
	[noidung] [nvarchar](200) NULL,
 CONSTRAINT [PK_thongbao] PRIMARY KEY CLUSTERED 
(
	[mataikhoan] ASC,
	[mathongbao] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
USE [master]
GO
ALTER DATABASE [sanbong] SET  READ_WRITE 
GO

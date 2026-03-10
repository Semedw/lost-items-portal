# Campus Lost Item Reporter - Frontend

A responsive React frontend application for reporting and managing lost items on campus, built with Vite, TypeScript, and Material-UI.

## Tech Stack

- **Vite** - Build tool and dev server
- **React 19** - UI framework
- **TypeScript** - Type safety
- **Material-UI** - Component library
- **Lucide React** - Icons
- **Axios** - HTTP client
- **React Router DOM** - Routing

## Project Structure

```
src/
├── components/
│   └── Navbar.tsx          # Navigation bar with routing links
├── pages/
│   ├── AllPosts.tsx        # View all lost item reports
│   ├── Create.tsx          # Create new lost item report
│   └── Edit.tsx            # Edit existing lost item report
├── main.tsx                # App entry point with routing setup
└── ...
```

## Features

### Navbar Component

- Responsive app bar with Material-UI
- Navigation links to All Posts and Report Lost Item
- Lucide React icons for visual enhancement

### AllPosts Page

- Displays all lost item reports in a responsive grid
- Shows item name, description, location, and contact information
- Edit button for each lost item
- Loading states and error handling
- Empty state with helpful message

### Create Page

- Form to report new lost items
- Fields: Item Name, Description, Location, Contact with the Founder (phone)
- Phone number validation
- Form validation
- Success/error feedback with alerts
- Auto-redirect after successful submission

### Edit Page

- Load and edit existing lost item reports
- Update all fields including contact information
- Delete functionality with confirmation
- Form validation and error handling
- Phone number validation

## Backend Integration

The frontend is configured to connect to a Java REST API at:

```
http://localhost:8080/api/lost-items
```

### Expected API Endpoints

Your Java backend should implement these endpoints:

```
GET    /api/lost-items          - Get all lost items
GET    /api/lost-items/{id}     - Get single lost item
POST   /api/lost-items          - Create new lost item
PUT    /api/lost-items/{id}     - Update lost item
DELETE /api/lost-items/{id}     - Delete lost item
```

### Expected Data Model

```typescript
{
  id: number;
  itemName: string;
  description: string;
  location: string;
  contactWithFounder: string; // Phone number
  reportedDate: string; // ISO date string
}
```

## Getting Started

### Installation

Dependencies are already installed. If you need to reinstall:

```bash
npm install
```

### Development

Start the development server:

```bash
npm run dev
```

The app will be available at `http://localhost:5173` (or the port Vite assigns).

### Build for Production

```bash
npm run build
```

## Configuration

To change the backend API URL, update the `API_BASE_URL` constant in each page component:

- `src/pages/AllPosts.tsx`
- `src/pages/Create.tsx`
- `src/pages/Edit.tsx`

## CORS Configuration

Make sure your Java backend allows CORS requests from your frontend origin. Add this to your Spring Boot application:

```java
@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:5173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
            }
        };
    }
}
```

## Component Features

### Security & User Experience

- Form validation on all inputs
- Phone number validation with regex pattern
- Loading states during API calls
- Error handling with user-friendly messages
- Confirmation dialogs for destructive actions
- Responsive design for mobile and desktop
- Accessible MUI components

### Visual Design

- Clean, professional interface
- Icons from Lucide React
- Material Design principles
- Smooth animations with Framer Motion

## Validation Rules

### Phone Number Format

The contact field accepts various phone number formats:

- Domestic: (123) 456-7890, 123-456-7890, 1234567890
- International: +1 (123) 456-7890, +44 20 1234 5678
- Flexible spacing and separators

## Next Steps

1. Start your Java backend on port 8080
2. Run `npm run dev` to start the frontend
3. Navigate to the application in your browser
4. Test creating, viewing, editing, and deleting lost item reports

## Troubleshooting

**"Failed to load lost items"**

- Ensure your Java backend is running on port 8080
- Check CORS configuration in your backend
- Verify API endpoints match expected format

**TypeScript Errors**

- Run `npm install` to ensure all dependencies are installed
- Check that all imports are correct

**Port Already in Use**

- Vite will automatically try the next available port
- Or stop the process using port 5173

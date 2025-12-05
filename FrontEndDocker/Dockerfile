# Stage 1: Use a lightweight Nginx image to serve Angular build
FROM nginx:alpine

# Remove default Nginx static files
RUN rm -rf /usr/share/nginx/html/*

# Copy the Angular build output from your local machine into Nginx
# Make sure you run `npm run build --prod` locally first
COPY ./dist/loan-app /usr/share/nginx/html

# Expose port 80
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
